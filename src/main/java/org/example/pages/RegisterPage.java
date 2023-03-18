package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.example.models.User;
import org.example.utils.CheckUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage extends BasePage {
    public static final String PAGE_URL = BASE_URL + "register";
    @FindBy(how = How.XPATH, using = ".//label[text()='Имя']/../input")
    private SelenideElement nameField;
    @FindBy(how = How.XPATH, using = ".//label[text()='Email']/../input")
    private SelenideElement emailField;
    @FindBy(how = How.XPATH, using = ".//label[text()='Пароль']/../input")
    private SelenideElement passwordField;
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;
    @FindBy(how = How.LINK_TEXT, using = "Войти")
    private SelenideElement loginLink;

    @Step("Register user with name '{0}', email '{1}, password '{2}'")
    public void registerUser(String name, String email, String password) {
        nameField.setValue(name);
        emailField.setValue(email);
        passwordField.setValue(password);
        registerButton.click();
    }

    @Step("Register user '{0}'")
    public void registerUser(User user) {
        nameField.setValue(user.getName());
        emailField.setValue(user.getEmail());
        passwordField.setValue(user.getPassword());
        registerButton.click();
    }

    @Step("Verify error on password field")
    public void verifyErrorOnPasswordField() {
        CheckUtils.verifyErrorOnField(passwordField, "Некорректный пароль");
    }

    @Step("Click Login link")
    public void clickLoginLink() {
        loginLink.click();
    }

}
