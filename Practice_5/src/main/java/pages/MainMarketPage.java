package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMarketPage extends BasePage {

    @FindBy(xpath = "//span[text()='Электроника']")
    private WebElement electronicsLink;

    public void clickToElectronicsLink() {
        electronicsLink.click();
        loaded();
    }

}