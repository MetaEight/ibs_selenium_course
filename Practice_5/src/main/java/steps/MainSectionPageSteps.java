package steps;

import io.cucumber.java.en.And;
import pages.MainSectionPage;

public class MainSectionPageSteps {

    @And("^Электроника: выберем раздел 'Телевизоры и аксесуары', а затем раздел 'Телевизоры'$")
    public FilteredProductsPageSteps openSectionTV(){
        MainSectionPage mainSectionPage = new MainSectionPage();
        mainSectionPage.selectSectionTVAndAccessories();
        mainSectionPage.selectSectionOnlyTV();

        return new FilteredProductsPageSteps();
    }

    @And("^Электроника: выберем раздел 'Наушники и аудиотехника', а затем раздел 'Наушники и Bluetooth-гарнитуры'$")
    public FilteredProductsPageSteps openSectionHeadphones(){
        MainSectionPage mainSectionPage = new MainSectionPage();
        mainSectionPage.selectSectionsectionHeadphones();
        mainSectionPage.selectSectionOnlyHeadphones();

        return new FilteredProductsPageSteps();
    }
}
