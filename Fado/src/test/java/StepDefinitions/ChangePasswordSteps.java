package StepDefinitions;

import PageObjects.*;
import io.cucumber.java.en.*;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ChangePasswordSteps {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    ProfilePage profilePage;
    ChangePassword changePassword;

    public ChangePasswordSteps()
    {
        this.driver = Hooks.driver;
        loginPage = new LoginPage(Hooks.driver);
        homePage = new HomePage(Hooks.driver);
        profilePage = new ProfilePage(Hooks.driver);
        changePassword = new ChangePassword(Hooks.driver);
    }
//    @Given("^Given The user already login to Fado website with username is \"([^\"]*)\" password is \"([^\"]*)\"$")
//    public void given_the_user_already_login_to_fado_website_with_username_is_something_password_is_something(String username, String password) {
//        this.loginPage.username.sendKeys(username);
//        this.loginPage.password.sendKeys(password);
//        this.loginPage.btnLogin.click();
//        this.homePage.btnCloseBanner.click();
//    }

    @Given("^The change password page is showed$")
    public void the_change_password_page_is_showed() throws Throwable {
        this.homePage.userName.click();
        this.homePage.EditProfileIcon.click();
        this.profilePage.ChangePasswordItem.click();
    }

    @When("^The user try to change password with blank value for all field$")
    public void the_user_try_to_change_password_with_blank_value_for_all_field() {
        this.changePassword.btnSubmit.click();
    }

    @When("^The user try to change password with wrong CurrentPassword$")
    public void the_user_try_to_change_password_with_wrong_CurrentPassword() {
        this.changePassword.CurrentPassword.sendKeys("A12345678@@");
        this.changePassword.NewPassword.sendKeys("NewPassword");
        this.changePassword.ConfirmPassword.sendKeys("NewPassword");
        this.changePassword.btnSubmit.click();
    }

    @When("^The user input ConfirmNewPassword is not match with NewPassword$")
    public void the_user_input_confirmnewpassword_is_not_match_with_newpassword() {
        this.changePassword.CurrentPassword.sendKeys("12345678");
        this.changePassword.NewPassword.sendKeys("123456789");
        this.changePassword.ConfirmPassword.sendKeys("1234567890");
        driver.findElement(By.xpath("//html")).click();
    }

    @When("^The user try to change password with valid data$")
    public void the_user_try_to_change_password_with_valid_data() {
        this.changePassword.CurrentPassword.sendKeys("A12345678@");
        this.changePassword.NewPassword.sendKeys("B12345678@");
        this.changePassword.ConfirmPassword.sendKeys("B12345678@");
        this.changePassword.btnSubmit.click();
    }
    @When("^The user try to change password with NewPassword is less than 6 characters$")
    public void the_user_try_to_change_password_with_newpassword_is_less_than_6_characters() {
        this.changePassword.NewPassword.sendKeys("1234");
        driver.findElement(By.xpath("//html")).click();
    }

    @Then("^The message \"([^\"]*)\" will be displayed next CurrentPassword field$")
    public void the_message_something_will_be_displayed_next_currentpassword_field(String strArg1) {
        assertThat(this.changePassword.CurrentPassErrorMessage.getText(), is("Vui lòng nhập dữ liệu"));
    }

    @Then("^The min length message \"([^\"]*)\" will be displayed next NewPassword field$")
    public void the_min_length_message_something_will_be_displayed_next_newpassword_field(String strArg1) {
        assertThat(this.changePassword._6CharsErrorMessage.getText(), is("Nhập tối thiểu từ 6 ký tự trở lên"));
    }
    @Then("^The wrong current password message \"([^\"]*)\" will be displayed$")
    public void the_wrong_current_password_message_something_will_be_displayed(String wrongMess) {
        assertThat(this.changePassword.GetWrongCurrentPassMessage().replace("\n", ""), is(wrongMess));
    }

    @Then("^The not match error message \"([^\"]*)\" will be displayed next ConfirmNewPassword field$")
    public void the_not_match_error_message_something_will_be_displayed_next_confirmnewpassword_field(String notMatchMess) {
        assertThat(this.changePassword.notMatchErrorMessage.getText(), is(notMatchMess));
    }

    @Then("^The success message \"([^\"]*)\" will be displayed$")
    public void the_success_message_something_will_be_displayed(String successMess) {
        assertThat(this.changePassword.GetChangePassSuccessMessage(), is(successMess));
    }

    @And("^The message \"([^\"]*)\" will be displayed next NewPassword field$")
    public void the_message_something_will_be_displayed_next_newpassword_field(String strArg1) {
        assertThat(this.changePassword.NewPassErrorMessage.getText(), is("Vui lòng nhập dữ liệu"));
    }

    @And("^The focus will be set on CurrentPassword field$")
    public void the_focus_will_be_set_on_currentpassword_field() {
        WebElement txtFocusElement = this.driver.switchTo().activeElement(); //Lay element dang co focus
        assertThat(txtFocusElement.getAttribute("name"), CoreMatchers.is("oldPassword"));
    }

//    @And("^The focus will be set on NewPassword field$")
//    public void the_focus_will_be_set_on_newpassword_field() {
//        WebElement txtFocusElement = this.driver.switchTo().activeElement(); //Lay element dang co focus
//        assertThat(txtFocusElement.getAttribute("name"), CoreMatchers.is("newPassword"));
//    }
}
