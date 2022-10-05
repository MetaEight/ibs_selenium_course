package project.steps;

import project.pages.NewBusinessTripPage;

public class NewBusinessTripPageSteps {

    NewBusinessTripPage newBusinessTripPage = new NewBusinessTripPage();

    public NewBusinessTripPageSteps selectSubdivision() {
        newBusinessTripPage.openSubdivisionsDropDownList();
        newBusinessTripPage.enterSubdivisionServicesDepartment();
        return new NewBusinessTripPageSteps();
    }

    public NewBusinessTripPageSteps selectOrganization() {
        newBusinessTripPage.openOrganizationDropDownList();
        newBusinessTripPage.selectOrganizationValue();
        return new NewBusinessTripPageSteps();
    }

    public NewBusinessTripPageSteps selectTask() {
        newBusinessTripPage.selectTask();
        return new NewBusinessTripPageSteps();
    }

    public NewBusinessTripPageSteps selectArrivalCity() {

        newBusinessTripPage.selectArrivalCity();
        return new NewBusinessTripPageSteps();
    }

    public NewBusinessTripPageSteps selectDepartureAndReturnDates() {
        newBusinessTripPage.selectDepartureDate();
        newBusinessTripPage.selectReturnDate();
        return new NewBusinessTripPageSteps();
    }

    public NewBusinessTripPageSteps validationEnteredData() {
        newBusinessTripPage.checkSubdivisionValue();
        newBusinessTripPage.checkOrganizationValue();
        newBusinessTripPage.checkTaskValue();
        newBusinessTripPage.checkDepartureCityValue();
        newBusinessTripPage.checkArrivalCityValue();
        return new NewBusinessTripPageSteps();
    }

    public NewBusinessTripPageSteps saveAndClose() {
        newBusinessTripPage.clickBtnSaveAndClose();
        return new NewBusinessTripPageSteps();
    }

    public NewBusinessTripPageSteps checkErrorMsg() {
        newBusinessTripPage.checkErrorMsg();
        return new NewBusinessTripPageSteps();
    }
}
