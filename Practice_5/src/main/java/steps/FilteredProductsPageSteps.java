package steps;

import io.cucumber.java.en.And;
import pages.FilteredProductsPage;

public class FilteredProductsPageSteps {

    @And("^Страница товаров: откроем страницу 'Все фильтры'$")
    public AllFiltersPageSteps openAllFilters(){
        FilteredProductsPage filteredProductsPage = new FilteredProductsPage();
        filteredProductsPage.clickToAllFilters();

        return new AllFiltersPageSteps();
    }

    @And("^Страница товаров: проверим что на странице отображается 12 товаров$")
    public FilteredProductsPageSteps checkThatCountOfProductsIsCorrect() {
        FilteredProductsPage filteredProductsPage = new FilteredProductsPage();
        filteredProductsPage.changeViewTypeToGrid();
        filteredProductsPage.checkCountOfProductsIsCorrect();

        return new FilteredProductsPageSteps();
    }

    @And("^Страница товаров/Телевизоры: получим имя первого товара в списке и проверим, найдется ли он через строку поиска$")
    public FilteredProductsPageSteps findFirstProductTV(){
        FilteredProductsPage filteredProductsPage = new FilteredProductsPage();
        String productName = filteredProductsPage.getFirstProductName();
        filteredProductsPage.enterProductNameAtSearchRow(productName);
        filteredProductsPage.TvSubmitSearchBtn();

        return new FilteredProductsPageSteps();
    }

    @And("^Страница товаров/Наушники: получим имя первого товара в списке и проверим, найдется ли он через строку поиска$")
    public FilteredProductsPageSteps findFirstProductHeadphones(){
        FilteredProductsPage filteredProductsPage = new FilteredProductsPage();
        String productName = filteredProductsPage.getFirstProductName();
        filteredProductsPage.enterProductNameAtSearchRow(productName);
        filteredProductsPage.headphonesSubmitSearchBtn();

        return new FilteredProductsPageSteps();
    }
}
