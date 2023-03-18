package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.example.models.User;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {
    public static final String PAGE_URL = BASE_URL + "login";
    @FindBy(how = How.NAME, using = "name")
    private SelenideElement emailField;
    @FindBy(how = How.NAME, using = "Пароль")
    private SelenideElement passwordField;
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement loginButton;
    @FindBy(how = How.LINK_TEXT, using = "Зарегистрироваться")
    private SelenideElement registrationLink;

    @Step("Login user with email '{0}' and password '{1}'")
    public void login(String email, String password) {
        emailField.setValue(email);
        passwordField.setValue(password);
        clickLoginButton();
    }

    @Step("Login user '{0}'")
    public void login(User user) {
        emailField.setValue(user.getEmail());
        passwordField.setValue(user.getPassword());
        clickLoginButton();
    }

    @Step("Click on login button")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step("Click on Registration link")
    public void clickRegistrationLink() {
        registrationLink.click();
    }
}
