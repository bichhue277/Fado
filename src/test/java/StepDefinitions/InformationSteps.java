package StepDefinitions;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.ProfilePage;
import PageObjects.UpdateInformation;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class InformationSteps {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    ProfilePage profilePage;
    UpdateInformation updateInformation;

    public InformationSteps()
    {
        this.driver = Hooks.driver;
        loginPage = new LoginPage(Hooks.driver);
        homePage = new HomePage(Hooks.driver);
        profilePage = new ProfilePage(Hooks.driver);
        updateInformation = new UpdateInformation(Hooks.driver);
    }

    @Given("^Given The user already login to Fado website with username is \"([^\"]*)\" password is \"([^\"]*)\"$")
    public void given_the_user_already_login_to_fado_website_with_username_is_something_password_is_something(String username, String password) {
        this.loginPage.username.sendKeys(username);
        this.loginPage.password.sendKeys(password);
        this.loginPage.btnLogin.click();
        this.homePage.btnCloseBanner.click();
    }
    @Given("^The update user information form is showed$")
    public void the_update_user_information_form_is_showed() {
        this.homePage.userName.click();
        this.homePage.EditProfileIcon.click();
    }

    @When("^The user try to show the Calendar popup for new value for birthday. \"([^\"]*)\" for example$")
    public void the_user_try_to_show_the_calendar_popup_for_new_value_for_birthday_something_for_example(String strArg1) {
        this.updateInformation.txtDOB.click();
        this.updateInformation.year.sendKeys("1990");
        this.updateInformation.month.click();
        this.updateInformation.day.click();
    }

    @When("^The user attempt to clear value of Fullname and Phone$")
    public void the_user_attempt_to_clear_value_of_fullname_and_phone() throws InterruptedException {
        new Actions(driver).moveToElement(this.updateInformation.txtFullName).click().perform();
        this.updateInformation.txtFullName.clear();
        driver.findElement(By.xpath("//html")).click();
        new Actions(driver).moveToElement(this.updateInformation.txtPhone).click().perform();
        this.updateInformation.txtPhone.clear();
        driver.findElement(By.xpath("//html")).click();
    }

    @When("^The user attempt to update with all valid values$")
    public void the_user_attempt_to_update_with_all_valid_values() {
        new Actions(driver).moveToElement(this.updateInformation.txtFullName).click().perform();
        this.updateInformation.txtFullName.clear();
        this.updateInformation.txtFullName.sendKeys("Bích Huệ");
        new Actions(driver).moveToElement(this.updateInformation.txtPhone).click().perform();
        this.updateInformation.txtPhone.clear();
        this.updateInformation.txtPhone.sendKeys("012345667");
        this.updateInformation.btnSubmit.click();
    }

    @When("^The user attempt to clear all values$")
    public void the_user_attempt_to_clear_all_values() {
        new Actions(driver).moveToElement(this.updateInformation.txtFullName).click().perform();
        this.updateInformation.txtFullName.clear();
        new Actions(driver).moveToElement(this.updateInformation.txtDOB).click().perform();
        this.updateInformation.txtDOB.clear();
        new Actions(driver).moveToElement(this.updateInformation.txtPhone).click().perform();
        this.updateInformation.txtPhone.clear();
    }

    @Then("^The current user information is showed for default$")
    public void the_current_user_information_is_showed_for_default() {
        assertThat(this.updateInformation.txtFullName.getAttribute("value"), is("hue"));
        assertThat(this.updateInformation.txtPhone.getAttribute("value"), is("0344224699"));
        assertThat(this.updateInformation.txtEmail.getAttribute("value"), is("bichhue11995@gmail.com"));
        assertThat(this.updateInformation.txtDOB.getAttribute("value"), is("03-05-1999"));
        this.updateInformation.txtGender.isSelected();
    }

    @Then("^The value of date of birth will be updated to \"([^\"]*)\"$")
    public void the_value_of_date_of_birth_will_be_updated_to_something(String strArg1) {
        assertThat(this.updateInformation.txtDOB.getAttribute("value"), is("21-01-1990"));
    }

    @Then("^The message \"([^\"]*)\" will be displayed below Fullname field$")
    public void the_message_something_will_be_displayed_below_fullname_field(String strArg1) throws InterruptedException {
        assertThat(this.updateInformation.FullNameErrorMess.getText(), is("Họ và tên là bắt buộc"));
    }

    @Then("^The message \"([^\"]*)\" will be showed$")
    public void the_message_something_will_be_showed(String strArg1) {
        assertThat(this.updateInformation.GetUpdateSuccessMess(), is("Quý khách đã cập nhập thông tin tài khoản thành công !"));
    }

    @Then("^The user should see blank value for all except email field$")
    public void the_user_should_see_blank_value_for_all_except_email_field() {
        assertThat(this.updateInformation.txtFullName.getAttribute("value"),is(""));
        assertThat(this.updateInformation.txtPhone.getAttribute("value"),is(""));
        assertThat(this.updateInformation.txtDOB.getAttribute("value"), is(""));
        assertThat(this.updateInformation.txtEmail.getAttribute("value"),is("bichhue11995@gmail.com"));
    }

    @And("^The email information can't be updated$")
    public void the_email_information_cant_be_updated() {
        this.updateInformation.txtEmail.getAttribute("disabled");
    }

//    @And("^The date of birth is display as dd\-mm\-yyyy format\.$")
//    public void the_date_of_birth_is_display_as_ddmmyyyy_format() {
//    }

    @And("^The message \"([^\"]*)\" will be displayed below phone number$")
    public void the_message_something_will_be_displayed_below_phone_number(String strArg1) {
        assertThat(this.updateInformation.PhoneErrorMess.getText(),is("Điện thoại là bắt buộc"));
    }

    @And("^The email field value is \"([^\"]*)\"$")
    public void the_email_field_value_is_something(String strArg1) throws InterruptedException {
        assertThat(this.updateInformation.txtEmail.getAttribute("value"),is("bichhue11995@gmail.com"));
    }
}
