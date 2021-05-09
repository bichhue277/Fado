package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(xpath = "//section[@id=\"header-section\"]//span[@class=\"user-name-col\"]")
    public WebElement userName;
    @FindBy(xpath = "//div[@class=\"user-name-label-col\"]")
    public WebElement UserName;

    public HomePage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
}
