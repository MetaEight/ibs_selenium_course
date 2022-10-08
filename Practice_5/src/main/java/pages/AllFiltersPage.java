package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllFiltersPage extends BasePage {

    @FindBy(xpath = "//h4[contains(text(), 'Цена')]/../..//div[@data-prefix='от']/input")
    private WebElement priceFromRow;

    @FindBy(xpath = "//h4[contains(text(), 'Производитель')]/../../div/div/div/input")
    private WebElement manufacturerNameRow;

    @FindBy(xpath = "//h4[contains(text(), 'Производитель')]/../../div/div/div/button")
    private WebElement manufacturerNameClearBtn;

    @FindBy(xpath = "//h4[contains(text(), 'Производитель')]/../..//input[@tabindex='0']/../div")
    private WebElement firstManufacturerCheckbox;

    @FindBy(xpath = "//a[contains(text(), 'Показать') and (contains(text(), 'предложения') or contains(text(), 'предложений') or contains(text(), 'предложение'))]")
    private WebElement viewFilteredProductsBtn;

    public void enterPriceFromToRaw(String price) {
        String offersCount = viewFilteredProductsBtn.getText();
        priceFromRow.sendKeys(price);
        check_attribute(priceFromRow, "value", price);
        wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBePresentInElement(viewFilteredProductsBtn, offersCount)));
    }

    public void enterManufactorerName(String manufacturerName) {
        manufacturerNameRow.sendKeys(manufacturerName);
        check_attribute(manufacturerNameRow, "value", manufacturerName);
    }

    public void selectManufactorerCheckbox() {
        String offersCount = viewFilteredProductsBtn.getText();
        firstManufacturerCheckbox.click();
        firstManufacturerCheckbox.isSelected();
        wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBePresentInElement(viewFilteredProductsBtn, offersCount)));

        manufacturerNameClearBtn.click();
    }

    public void viewFilteredProducts() {
        viewFilteredProductsBtn.click();
        loaded();
    }

}
