package PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    @FindBy(xpath = "//form[@id=\"auth-block__login-form\"]//input[@type=\"email\"]")
    public WebElement username;
    @FindBy(xpath = "//form[@id=\"auth-block__login-form\"]//input[@type=\"password\"]")
    public WebElement password;
    @FindBy(xpath = "//form[@id=\"auth-block__login-form\"]//button[@type=\"submit\"]")
    public WebElement btnLogin;


    public LoginPage(WebDriver driver)
    {
        driver.get("https://fado.vn/dang-nhap");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        PageFactory.initElements(driver,this);
    }
}
