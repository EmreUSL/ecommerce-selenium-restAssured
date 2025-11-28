package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.time.Duration;

public class DriverFactory {

    private static volatile DriverFactory instance;
    private final OptionsManager options = new OptionsManager();

    private DriverFactory() {}

    public static DriverFactory getInstance() {
        if (instance == null) {
            synchronized (DriverFactory.class) {
                if (instance == null) {
                    instance = new DriverFactory();
                }
            }
        }
        return instance;
    }

    public void createDriver(BrowserType browserType) {
        WebDriver driver = switch (browserType) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                yield new ChromeDriver(options.getChromeOptions());
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                yield new FirefoxDriver(options.getFirefoxOptions());
            }
            case EDGE -> {
                WebDriverManager.edgedriver().setup();
                yield new EdgeDriver(options.getEdgeOptions());
            }
            case SAFARI -> {
                WebDriverManager.safaridriver().setup();
                yield new SafariDriver(options.getSafariOptions());
            }
            default -> throw new IllegalArgumentException("Unsupported browser: " + browserType);
        };

        DriverManager.setDriver(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }
}
