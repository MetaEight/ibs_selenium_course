package project.steps;

import io.qameta.allure.Step;
import project.pages.BusinessTripListPage;

public class BusinessTripListPageSteps {

    @Step("Страница командировок: нажимаем Создать командировку")
    public void CreateNewBusinessTrip(){
        BusinessTripListPage businessTripListPage = new BusinessTripListPage();
        businessTripListPage.newBusinessTripClick();
    }

}
