package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.BeforeStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {
    public static WebDriver driver;
    @Before
    public void iniDriver()
    {
        String browser = System.getProperty("browser","chrome");
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
    }
    @After
    public void close()
    {
        this.driver.close();
    }
}
