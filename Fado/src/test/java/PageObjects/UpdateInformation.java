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
    public WebElement fullName;
    @FindBy(xpath = "//form[@class=\"user-block__input-form\"]//input[@name=\"phone\"]")
    public WebElement phone;
    @FindBy(xpath = "//form[@class=\"user-block__input-form\"]//input[@name=\"email\"]")
    public WebElement email;
    @FindBy(xpath = "//form[@class=\"user-block__input-form\"]//input[@name=\"birthdate\"]")
    public WebElement DOB;
    @FindBy(xpath = "//input[@name=\"gender\"][@value=\"2\"]")
    public WebElement gender;
    @FindBy(xpath = "//form[@class=\"user-block__input-form\"]//div[@class=\"my-btn__inner\"]")
    public WebElement btnNhapLai;
    @FindBy(xpath = "//form[@class=\"user-block__input-form\"]//button[@type=\"submit\"]")
    public WebElement btnSubmit;

    public UpdateInformation(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
}
