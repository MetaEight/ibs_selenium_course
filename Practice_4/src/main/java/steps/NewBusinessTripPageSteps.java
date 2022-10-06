package steps;

import io.cucumber.java.en.And;
import pages.NewBusinessTripPage;

public class NewBusinessTripPageSteps {

    NewBusinessTripPage newBusinessTripPage = new NewBusinessTripPage();

    @And("^Страница создания командировки: выбрать значение для поля Подразделение$")
    public NewBusinessTripPageSteps selectSubdivision() {
        newBusinessTripPage.openSubdivisionsDropDownList();
        newBusinessTripPage.enterSubdivisionServicesDepartment();
        return new NewBusinessTripPageSteps();
    }

    @And("^Страница создания командировки: выбрать значение для поля Организация$")
    public NewBusinessTripPageSteps selectOrganization() {
        newBusinessTripPage.openOrganizationDropDownList();
        newBusinessTripPage.selectOrganizationValue();
        return new NewBusinessTripPageSteps();
    }

    @And("^Страница создания командировки: выбрать задачу$")
    public NewBusinessTripPageSteps selectTask() {
        newBusinessTripPage.selectTask();
        return new NewBusinessTripPageSteps();
    }

    @And("^Страница создания командировки: выбрать значение для поля Город прибытия$")
    public NewBusinessTripPageSteps selectArrivalCity() {

        newBusinessTripPage.selectArrivalCity();
        return new NewBusinessTripPageSteps();
    }

    @And("^Страница создания командировки: выбрать значение для полей Дата отправления и Дата возвращения$")
    public NewBusinessTripPageSteps selectDepartureAndReturnDates() {
        newBusinessTripPage.selectDepartureDate();
        newBusinessTripPage.selectReturnDate();
        return new NewBusinessTripPageSteps();
    }

    @And("^Страница создания командировки: проверить выбранные значения$")
    public NewBusinessTripPageSteps validationEnteredData() {
        newBusinessTripPage.checkSubdivisionValue();
        newBusinessTripPage.checkOrganizationValue();
        newBusinessTripPage.checkTaskValue();
        newBusinessTripPage.checkDepartureCityValue();
        newBusinessTripPage.checkArrivalCityValue();
        return new NewBusinessTripPageSteps();
    }

    @And("^Страница создания командировки: нажать на кнопку 'Сохранить и выйти'$")
    public NewBusinessTripPageSteps saveAndClose() {
        newBusinessTripPage.clickBtnSaveAndClose();
        return new NewBusinessTripPageSteps();
    }

    @And("^Страница создания командировки: проверить текст ошибки$")
    public NewBusinessTripPageSteps checkErrorMsg() {
        newBusinessTripPage.checkErrorMsg();
        return new NewBusinessTripPageSteps();
    }
}
