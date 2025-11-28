package test;

import core.BrowserType;
import core.DriverFactory;
import core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        DriverFactory.getInstance().createDriver(BrowserType.CHROME);
        DriverManager.getDriver().get("https://www.demoblaze.com/");
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
