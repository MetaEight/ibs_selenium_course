package project.steps;

import project.pages.MainPage;

public class MainPageSteps {

    public BusinessTripListPageSteps filterByAssignment(){
        MainPage mainPage = new MainPage();
        mainPage.costsClick();
        mainPage.assignmentClick();

        return new BusinessTripListPageSteps();
    }

}
