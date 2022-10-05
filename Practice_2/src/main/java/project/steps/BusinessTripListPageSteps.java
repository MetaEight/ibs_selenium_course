package project.steps;

import project.pages.BusinessTripListPage;

public class BusinessTripListPageSteps {

    public void CreateNewBusinessTrip(){
        BusinessTripListPage businessTripListPage = new BusinessTripListPage();
        businessTripListPage.newBusinessTripClick();
    }

}
