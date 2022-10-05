package project.steps;

import io.qameta.allure.Step;
import project.pages.LoginPage;

public class LoginSteps {

    @Step("Страница авторизации: вводим логин {0} и пароль {1}, нажимаем Войти")
    public MainPageSteps login(String login, String password){
        LoginPage loginPage = new LoginPage();
        loginPage.enterLoginAndPassword(login, password);
        loginPage.submitClick();

        return new MainPageSteps();
    }
}
