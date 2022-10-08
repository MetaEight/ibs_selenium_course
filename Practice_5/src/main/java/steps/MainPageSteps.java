package steps;

import io.cucumber.java.en.And;
import pages.MainPage;

public class MainPageSteps {

    @And("^Главная страница: раскрываем список всех сервисов, находим 'Яндекс маркет' и открываем$")
    public MainMarketPageSteps openMarket(){
        MainPage mainPage = new MainPage();
        mainPage.expandListOfServices();
        mainPage.openMarket();

        return new MainMarketPageSteps();
    }

}
