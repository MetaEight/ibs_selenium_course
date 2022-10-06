package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;

public class BusinessTripListPage extends BasePage {

    @FindBy(xpath = "//a[contains(@href, '/business-trip/create/') and @title='Создать командировку']")
    private WebElement newBusinessTripBtn;

    public void newBusinessTripClick() {
        newBusinessTripBtn.click();
    }

}
