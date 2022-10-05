package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import project.properties.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static WebDriver driver;
    private static Properties properties = TestProperties.getInstance().getProperties();

    public static WebDriver getWebDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void initDriver() {
        driver = new ChromeDriver();
        System.setProperty(properties.getProperty("WEB_DRIVER"), properties.getProperty("WEB_DRIVER_PATH"));

        driver.get(properties.getProperty("HOSTNAME"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void closeDriver() {
        driver.quit();
    }
}
