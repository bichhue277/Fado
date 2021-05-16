package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangePassword {
    @FindBy(xpath = "//form[@id=\"user-block--change-password__change-password-form\"]//input[@name=\"oldPassword\"]")
    public WebElement CurrentPassword;
    @FindBy(xpath = "//form[@id=\"user-block--change-password__change-password-form\"]//input[@name=\"newPassword\"]")
    public WebElement NewPassword;
    @FindBy(xpath = "//form[@id=\"user-block--change-password__change-password-form\"]//input[@name=\"reNewPassword\"]")
    public WebElement ConfirmPassword;
    @FindBy(xpath = "//form[@id=\"user-block--change-password__change-password-form\"]//button[@type=\"submit\"]")
    public WebElement btnSubmit;
    @FindBy(xpath = "//form[@id=\"user-block--change-password__change-password-form\"]//label[@id=\"oldPassword-error\"]")
    public WebElement CurrentPassErrorMessage;
    @FindBy(xpath = "//form[@id=\"user-block--change-password__change-password-form\"]//label[@id=\"user-block--change-password__new-password-input-error\"]")
    public WebElement NewPassErrorMessage;
    @FindBy(xpath = "//form[@id=\"user-block--change-password__change-password-form\"]//label[@id=\"reNewPassword-error\"]")
    public WebElement ConfirmPassErrorMessage;
    @FindBy(xpath = "//form[@id=\"user-block--change-password__change-password-form\"]//label[contains(text(),'Nhập tối thiểu từ 6 ký tự trở lên')]")
    public WebElement _6CharsErrorMessage;
    @FindBy(xpath = "//form[@id=\"user-block--change-password__change-password-form\"]//label[contains(text(),'Mật khẩu nhập lại không trùng khớp')]")
    public WebElement notMatchErrorMessage;

    By lbWrongCurrentPassMessage = By.xpath("//form[@id=\"user-block--change-password__change-password-form\"]//div[@class=\"my-alert -alert-danger\"]");
    By lbChagePassSuccessMessage = By.xpath("//form[@id=\"user-block--change-password__change-password-form\"]//div[@class=\"my-alert -alert-success\"]");
    WebDriver driver;
    public ChangePassword(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
    public String GetWrongCurrentPassMessage()
    {
        WebDriverWait wait = new WebDriverWait(this.driver,15);
        WebElement WrongCurrentPassMessage =wait.until(ExpectedConditions.presenceOfElementLocated(lbWrongCurrentPassMessage));
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return WrongCurrentPassMessage.getText();
    }

    public String GetChangePassSuccessMessage()
    {
        WebDriverWait wait = new WebDriverWait(this.driver,20);
        WebElement ChangePassSuccessMessage = wait.until(ExpectedConditions.presenceOfElementLocated(lbChagePassSuccessMessage));
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return ChangePassSuccessMessage.getText();
    }
}
