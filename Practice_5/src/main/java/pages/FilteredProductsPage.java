package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FilteredProductsPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(), 'Все фильтры')]/../../..")
    private WebElement allFilters;

    @FindBy(xpath = "//input[@name='viewType' and @value='grid']")
    private WebElement viewTypeGrid;

    @FindBy(xpath = "//input[@name='viewType' and @value='grid']")
    private WebElement productsGrid;

    @FindBy(xpath = "//span[@aria-label='Загрузка...']")
    private WebElement loadingIcon;

    @FindBy(xpath =
            "//div[@data-index and @style='overflow-anchor: none;' and not(self::div[@data-index='0'])]/div/div/div/article")
    private WebElement productsOnFirstPage;

    @FindBy(xpath =
            "//div[@data-index and @style='overflow-anchor: none;' and not(self::div[@data-index='0'])]//a[@data-baobab-name='title']/span")
    private WebElement firstProductName;

    @FindBy(xpath = "//input[@id='header-search']")
    private WebElement searchRaw;

    @FindBy(xpath = "//button[@data-r='search-button']")
    private WebElement searchBtn;

    public void clickToAllFilters() {
        allFilters.click();
    }

    public void changeViewTypeToGrid() {
        viewTypeGrid.click();
        check_attribute(viewTypeGrid.findElement(By.xpath("../span")), "class", "_3hqmN");
    }

    public void checkCountOfProductsIsCorrect() {
        viewTypeGrid.click();
        check_attribute(viewTypeGrid.findElement(By.xpath("../span")), "class", "_3hqmN");
        List<WebElement> prod = driver.findElements(By.xpath("//div[@data-index and @style='overflow-anchor: none;' and not(self::div[@data-index='0'])]/div/div/div/article"));
        assert prod.size() == 12;
    }

    public String getFirstProductName() {
        return firstProductName.getText();
    }

    public void enterProductNameAtSearchRow(String productName) {
        searchRaw.sendKeys(productName);
    }

    public void TvSubmitSearchBtn() {
        searchBtn.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Телевизоры — купить по низкой цене на Яндекс Маркете")));
    }

    public void headphonesSubmitSearchBtn() {
        searchBtn.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Наушники и Bluetooth-гарнитуры желтого цвета — купить по низкой цене на Яндекс Маркете")));
    }


}