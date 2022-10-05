package basetestclass;

import project.steps.LoginSteps;
import project.steps.NewBusinessTripPageSteps;

import java.util.Properties;

import static project.properties.TestProperties.getInstance;

public class BaseTest {

    public final LoginSteps loginSteps = new LoginSteps();
    public final Properties properties = getInstance().getProperties();

    public NewBusinessTripPageSteps GoToPageCreateNewBusinessTrip(){
        loginSteps
                .login( properties.getProperty("LOGIN"),
                        properties.getProperty("PASSWORD"))
                .filterByAssignment()
                .CreateNewBusinessTrip();

        return new NewBusinessTripPageSteps();
    }

}
