package project.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import project.BasePage;

public class NewBusinessTripPage extends BasePage {

    @FindBy(xpath = "//select[contains(@name, 'crm_business_trip[businessUnit]')]")
    private WebElement subdivisionsRow;

    @FindBy(xpath = "//select[contains(@name, 'crm_business_trip[businessUnit]')]/..")
    private WebElement subdivisionsDropDownList;

    @FindBy(xpath = "//select[contains(@name, 'crm_business_trip[businessUnit')]/option[@value='6']")
    private WebElement subdivisionServicesDepartment;

    @FindBy(xpath = "//a[@id='company-selector-show']")
    private WebElement organizationRow;

    @FindBy(xpath = "//a[@class='select2-choice select2-default']")
    private WebElement organizationDropDownListBtn;

    @FindBy(xpath = "//a[@class='select2-choice select2-default']/..")
    private WebElement organizationDropDownList;

    @FindBy(xpath = "//div[@class='select2-result-label' and text()='(Хром) Призрачная Организация Охотников']")
    private WebElement organizationRequiredValue;

    @FindBy(xpath = "//input[@data-name='field__1']")
    private WebElement taskCheckbox;

    @FindBy(xpath = "//input[@name='crm_business_trip[arrivalCity]']")
    private WebElement arrivalCityRow;

    @FindBy(xpath = "//input[@placeholder='Планируемая дата выезда']/../../input")
    private WebElement departureDateRow;

    @FindBy(xpath = "//input[@placeholder='Планируемая дата возвращения']/../../input")
    private WebElement returnDateRow;

    @FindBy(xpath = "//select[contains(@name, 'crm_business_trip[businessUnit]')]/../span")
    private WebElement subdivisionValue;

    @FindBy(xpath = "//span[@class='select2-chosen']")
    private WebElement organizationValue;

    @FindBy(xpath = "//input[@name='crm_business_trip[departureCity]']")
    private WebElement departureCityValue;

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]/..")
    private WebElement saveAndCloseBtn;

    @FindBy(xpath = "//span[text()='Командированные сотрудники']/../..//span[@class='validation-failed']")
    private WebElement errorMsg;

    public void openSubdivisionsDropDownList() {
        subdivisionsRow.click();
        check_attribute(subdivisionsDropDownList, "class", "focus");
    }

    public void enterSubdivisionServicesDepartment() {
        subdivisionServicesDepartment.click();
    }

    public void openOrganizationDropDownList() {
        organizationRow.click();
        organizationDropDownListBtn.click();
        check_attribute(organizationDropDownList, "class", "select2-dropdown-open");
    }

    public void selectOrganizationValue() {
        organizationRequiredValue.click();
    }

    public void selectTask() {
        taskCheckbox.click();
    }

    public void selectArrivalCity() {
        arrivalCityRow.sendKeys("Россия, Брянск");
    }

    public void selectDepartureDate() {
        departureDateRow.sendKeys("28.09.2022" + Keys.TAB);
    }

    public void selectReturnDate() {
        returnDateRow.sendKeys("01.10.2022" + Keys.TAB);
    }


    public void checkSubdivisionValue() {
        Assertions.assertEquals(
                subdivisionValue.getText(),
                "Отдел проектных сервисов",
                "Выбрано неверное значение");
    }

    public void checkOrganizationValue() {
        Assertions.assertEquals(
                organizationValue.getText(),
                "(Хром) Призрачная Организация Охотников",
                "Выбрано неверное значение");
    }

    public void checkTaskValue() {
        assert taskCheckbox.isSelected();
    }

    public void checkDepartureCityValue() {
        Assertions.assertEquals(
                departureCityValue.getAttribute("value"),
                "Россия, Москва",
                "Выбрано неверное значение");
    }

    public void checkArrivalCityValue() {
        Assertions.assertEquals(
                arrivalCityRow.getAttribute("value"),
                "Россия, Брянск",
                "Выбрано неверное значение");
    }

    public void clickBtnSaveAndClose() {
        saveAndCloseBtn.click();
    }

    public void checkErrorMsg() {
        Assertions.assertEquals(
                errorMsg.getText(),
                "Список командируемых сотрудников не может быть пустым",
                "Выбрано неверное значение");
    }

}
