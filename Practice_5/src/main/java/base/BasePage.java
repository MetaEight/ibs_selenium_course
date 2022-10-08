package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static org.openqa.selenium.support.PageFactory.*;
import static base.DriverManager.getWebDriver;

public class BasePage {

    @FindBy(xpath = "//div[@data-baobab-name = 'home']")
    private WebElement logo;

    protected static WebDriver driver = getWebDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 10);

    public BasePage() {
        initElements(driver, this);
    }

    public void check_attribute(WebElement element, String attribute, String value) {
        wait.until(ExpectedConditions.attributeContains(element, attribute, value));
    }

    public void loaded() {
        wait.until(ExpectedConditions.visibilityOf(logo));
    }

    public void switchHandler(){
        Set<String> tab_handles = driver.getWindowHandles();
        int number_of_tabs = tab_handles.size();
        int new_tab_index = number_of_tabs-1;
        driver.switchTo().window(tab_handles.toArray()[new_tab_index].toString());
    }

}
