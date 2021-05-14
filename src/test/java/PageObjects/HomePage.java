package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage {
    @FindBy(xpath = "//section[@id=\"header-section\"]//span[@class=\"user-name-col\"]")
    public WebElement userName;
    @FindBy(xpath = "//div[@class=\"header-main-block__user-col\"]//img[@class=\"user-edit-profile-icon\"]")
    public WebElement EditProfileIcon;
    @FindBy(xpath = "//div[@id=\"bner-center-modal\"]//button[@class=\"close\"]")
    public WebElement btnCloseBanner;

    public HomePage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
}
