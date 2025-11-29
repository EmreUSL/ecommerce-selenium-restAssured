package test;

import core.BrowserType;
import core.DriverFactory;
import core.DriverManager;
import core.util.WaitUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverFactory.getInstance().createDriver(BrowserType.CHROME);
        WaitUtil.init(DriverManager.getDriver());
        DriverManager.getDriver().get("https://www.demoblaze.com/");
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
