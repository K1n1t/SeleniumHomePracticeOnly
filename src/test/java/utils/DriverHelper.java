package utils;

// This is an example of Singleton design

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

import static org.openqa.selenium.remote.HttpSessionId.getSessionId;

public class DriverHelper {
    // private variable
    public static WebDriver driver;

    // private constructor
    private DriverHelper(){} /* the reason why we did private is
                                bacause we need to prevent others to create object out of this class.
                                This is another great example of Encapsulation */
    public static WebDriver  getDriver() {
        if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {
            switch (ConfigReader.readProperty("browser")) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    driver = new FirefoxDriver();

                case "edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }
}
