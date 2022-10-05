package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.PageFactory.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static project.DriverManager.getWebDriver;

public class BasePage {

    protected static WebDriver driver = getWebDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 10);

    public BasePage() {
        initElements(driver, this);
    }

    public void check_attribute(WebElement element, String attribute, String value) {
        wait.until(ExpectedConditions.attributeContains(element, attribute, value));
    }


}
