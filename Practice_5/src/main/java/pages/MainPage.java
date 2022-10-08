package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class MainPage extends BasePage {

    @FindBy(xpath = "//a[@title='Все сервисы']")
    private WebElement servicesFolder;

    @FindBy(xpath = "//a[contains(@href, 'market.yandex')]")
    private WebElement marketIcon;

    @FindBy(xpath = "//span[text()='Командировки']")
    private WebElement assignmentBtn;

    public void expandListOfServices(){
        servicesFolder.click();
        check_attribute(servicesFolder, "aria-expanded", "true");
    }

    public void openMarket(){
        marketIcon.click();
        switchHandler();
        wait.until(urlContains("market"));
        loaded();
    }
}
