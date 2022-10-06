package steps;

import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import pages.LoginPage;

public class LoginSteps {

    @And("^Страница авторизации: вводим логин \"([^\"]*)\" и пароль \"([^\"]*)\", нажимаем Войти$")
    public MainPageSteps login(String login, String password){
        LoginPage loginPage = new LoginPage();
        loginPage.enterLoginAndPassword(login, password);
        loginPage.submitClick();

        return new MainPageSteps();
    }
}
