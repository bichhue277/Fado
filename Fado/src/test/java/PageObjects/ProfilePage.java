package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    @FindBy(xpath = "//div[@class=\"user-info-card\"]//li[@class=\"info-item\"]//a[@href=\"/thong-tin-ca-nhan\"]")
    public WebElement informationItem;


    public ProfilePage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
}
