package core;

import config.ConfigReader;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

//Browser Options
public class OptionsManager {

    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions= new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return chromeOptions;
    }

    public FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (Boolean.parseBoolean(ConfigReader.get("headless"))) {
            firefoxOptions.addArguments("-headless");
        }
        return firefoxOptions;
    }

    public EdgeOptions getEdgeOptions() {
        return new EdgeOptions();
    }

    public SafariOptions getSafariOptions() {
        return new SafariOptions();
    }
}
