package steps;

import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import pages.MainPage;

public class MainPageSteps {

    @And("^Главная страница: выбираем пункт меню 'Расходы' и переходим к командировкам$")
    public BusinessTripListPageSteps filterByAssignment(){
        MainPage mainPage = new MainPage();
        mainPage.costsClick();
        mainPage.assignmentClick();

        return new BusinessTripListPageSteps();
    }

}
