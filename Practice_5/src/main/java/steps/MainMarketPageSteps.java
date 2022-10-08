package steps;

import io.cucumber.java.en.And;
import pages.MainMarketPage;

public class MainMarketPageSteps {

    @And("^Главная страница Маркета: открываем раздел 'Электроника'$")
    public MainSectionPageSteps openSectionElectronics(){
        MainMarketPage mainMarketPage = new MainMarketPage();
        mainMarketPage.clickToElectronicsLink();
        return new MainSectionPageSteps();
    }
}
