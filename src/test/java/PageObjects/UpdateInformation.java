package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class UpdateInformation {
    @FindBy(xpath = "//form[@class=\"user-block__input-form\"]//input[@name=\"fullname\"]")
    public WebElement txtFullName;
    @FindBy(xpath = "//form[@class=\"user-block__input-form\"]//input[@name=\"phone\"]")
    public WebElement txtPhone;
    @FindBy(xpath = "//form[@class=\"user-block__input-form\"]//input[@name=\"email\"]")
    public WebElement txtEmail;
    @FindBy(xpath = "//form[@class=\"user-block__input-form\"]//input[@name=\"birthdate\"]")
    public WebElement txtDOB;
    @FindBy(xpath = "//input[@name=\"gender\"][@value=\"2\"]")
    public WebElement txtGender;
    @FindBy(xpath = "//form[@class=\"user-block__input-form\"]//div[@class=\"my-btn__inner\"]")
    public WebElement btnNhapLai;
    @FindBy(xpath = "//form[@class=\"user-block__input-form\"]//button[@type=\"submit\"]")
    public WebElement btnSubmit;
    @FindBy(xpath = "//form[@class=\"user-block__input-form\"]//label[contains(text(),'Họ và tên là bắt buộc')]")
    public WebElement FullNameErrorMess;
    @FindBy(xpath = "//form[@class=\"user-block__input-form\"]//label[contains(text(),'Ngày sinh là bắt buộc')]")
    public WebElement DOBErrorMess;
    @FindBy(xpath = "//form[@class=\"user-block__input-form\"]//label[contains(text(),'Điện thoại là bắt buộc')]")
    public WebElement PhoneErrorMess;
    @FindBy(xpath = "//div[@class=\"flatpickr-months\"]//div[@class=\"numInputWrapper\"]//input")
    public WebElement year;
    @FindBy(xpath = "//div[@class=\"flatpickr-months\"]//select//option[contains(text(),\"Tháng một\")]")
    public WebElement month;
    @FindBy(xpath = "//div[@class=\"dayContainer\"]//span[contains(@class,'flatpickr-day') and text()='21' and not(contains(@class,'prevMonthDay'))  and not(contains(@class,'nextMonthDay'))]")
    public WebElement day;
    By updateSuccessMess = By.xpath("//form[@class=\"user-block__input-form\"]//div[@class=\"my-alert -alert-success\"]");

    WebDriver driver;
    public UpdateInformation(WebDriver driver)
    {
        driver.get("https://fado.vn/thong-tin-ca-nhan");
        PageFactory.initElements(driver,this);
    }

    public String GetUpdateSuccessMess()
    {
        WebDriverWait wait = new WebDriverWait(this.driver,15);
        WebElement SuccessMess =wait.until(ExpectedConditions.presenceOfElementLocated(updateSuccessMess));
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return SuccessMess.getText();
    }
}
