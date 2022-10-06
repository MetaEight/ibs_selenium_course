package steps;

import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import pages.BusinessTripListPage;

public class BusinessTripListPageSteps {

    @And("^Страница командировок: нажимаем Создать командировку$")
    public void CreateNewBusinessTrip(){
        BusinessTripListPage businessTripListPage = new BusinessTripListPage();
        businessTripListPage.newBusinessTripClick();
    }

}
