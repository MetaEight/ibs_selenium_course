package project.steps;

import io.qameta.allure.Step;
import project.pages.MainPage;

public class MainPageSteps {

    @Step("Главная страница: выбираем пункт меню 'Расходы' и переходим к командировкам")
    public BusinessTripListPageSteps filterByAssignment(){
        MainPage mainPage = new MainPage();
        mainPage.costsClick();
        mainPage.assignmentClick();

        return new BusinessTripListPageSteps();
    }

}
