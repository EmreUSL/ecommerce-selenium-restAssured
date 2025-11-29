package base;

import core.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(By locator) {
        try {
            return driver.findElement(locator);
        } catch (Exception e) {
            throw new NoSuchElementException("Element not found! Locator: " + locator, e);
        }
    }

    public void sendText(By locator, String value) {
        try {
            WebElement element = WaitUtil.waitForVisible(locator);
            element.clear();
            element.sendKeys(value);
        } catch (Exception e) {
            throw new RuntimeException("Cannot set element!" + locator, e);
        }

    }

    public void click(By locator) {
        try {
            WebElement element = WaitUtil.waitForVisible(locator);
            element.click();
        } catch (Exception e) {
            throw new RuntimeException("Cannot click element!" + locator, e);
        }

    }
}
