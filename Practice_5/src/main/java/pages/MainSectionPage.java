package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainSectionPage extends BasePage {

    @FindBy(xpath = "//a[contains(@href, 'televizory')]")
    private WebElement sectionTV;

    @FindBy(xpath = "//a[contains(@href, 'naushniki')]")
    private WebElement sectionHeadphones;
    @FindBy(xpath = "//a[contains(@href, 'televizory') and @class='_20WYq _1gCbc']")
    private WebElement sectionOnlyTV;

    @FindBy(xpath = "//a[contains(@href, 'naushniki') and @class='_20WYq _1gCbc']")
    private WebElement sectionOnlyHeadphones;

    public void selectSectionTVAndAccessories() {
        sectionTV.click();
        loaded();
    }

    public void selectSectionsectionHeadphones() {
        sectionHeadphones.click();
        loaded();
    }

    public void selectSectionOnlyTV() {
        sectionOnlyTV.click();
        loaded();
    }

    public void selectSectionOnlyHeadphones() {
        sectionOnlyHeadphones.click();
        loaded();
    }
}
