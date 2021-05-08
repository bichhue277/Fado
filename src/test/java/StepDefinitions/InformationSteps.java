package StepDefinitions;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.ProfilePage;
import PageObjects.UpdateInformation;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class InformationSteps {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    ProfilePage profilePage;
    UpdateInformation updateInformation;

    public InformationSteps()
    {
        this.driver = Hooks.driver;
    }

    @Given("The user already login with username is {string} password is {string}")
    public void the_user_already_login_with_username_is_password_is(String username, String password) {
        this.driver.get("https://fado.vn/dang-nhap");
        this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        this.loginPage = new LoginPage(this.driver);
        this.loginPage.username.sendKeys(username);
        this.loginPage.password.sendKeys(password);
        this.loginPage.btnLogin.click();
    }

    @Given("The {string} page is displayed")
    public void the_something_page_is_displayed(String strArg1) {
        this.homePage.userName.click();
        this.homePage.UserName.click();
    }

    @When("The user click on {string}")
    public void the_user_click_on_something(String strArg1) {
        this.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        this.profilePage.informationItem.click();
    }

    @Then("^All information is fill out$")
    public void all_information_is_fill_out() {

    }
}
