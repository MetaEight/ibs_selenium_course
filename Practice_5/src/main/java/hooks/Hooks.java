package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static base.DriverManager.closeDriver;
import static base.DriverManager.getWebDriver;

public class Hooks {

    final WebDriver driver = getWebDriver();

    @After
    public void tearDown(Scenario scenario) {
        String screenshotName = scenario.getName().replace(" ", "_");
        try {
            if (scenario.isFailed()) {
                scenario.log("Ошибка");
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screeeshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screeeshot, "image/png", screenshotName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeDriver();
    }

}
