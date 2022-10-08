package steps;

import io.cucumber.java.en.And;
import pages.AllFiltersPage;

public class AllFiltersPageSteps {

    @And("^Все фильтры: стоимость товаров от \"([^\"]*)\"$")
    public AllFiltersPageSteps enterPriceFrom(String price){
        AllFiltersPage allFiltersPage = new AllFiltersPage();
        allFiltersPage.enterPriceFromToRaw(price);

        return new AllFiltersPageSteps();
    }

    @And("^Все фильтры: производитель \"([^\"]*)\"$")
    public AllFiltersPageSteps selectManufactorer(String manufacturer){
        AllFiltersPage allFiltersPage = new AllFiltersPage();
        allFiltersPage.enterManufactorerName(manufacturer);
        allFiltersPage.selectManufactorerCheckbox();

        return new AllFiltersPageSteps();
    }

    @And("^Все фильтры: показать товары$")
    public FilteredProductsPageSteps enterPriceFrom2(){
        AllFiltersPage allFiltersPage = new AllFiltersPage();
        allFiltersPage.viewFilteredProducts();

        return new FilteredProductsPageSteps();
    }
}
