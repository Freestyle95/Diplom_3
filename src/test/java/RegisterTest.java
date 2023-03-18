import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.Browser;
import org.example.models.User;
import org.example.pages.LoginPage;
import org.example.pages.RegisterPage;
import org.example.utils.CheckUtils;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class RegisterTest extends BaseTest {

    public RegisterTest(Browser browser) {
        super(browser);
    }

    @Test
    @DisplayName("Successful registration")
    public void successfulRegistration() {
        user = User.generateRandomUser();
        RegisterPage registerPage = open(RegisterPage.PAGE_URL, RegisterPage.class);
        registerPage.registerUser(user);
        CheckUtils.verifyPageUrl(LoginPage.PAGE_URL);
    }

    @Test
    @DisplayName("Incorrect password error")
    public void incorrectPasswordError() {
        RegisterPage registerPage = open(RegisterPage.PAGE_URL, RegisterPage.class);
        user = User.generateRandomUser();
        user.setPassword(RandomStringUtils.randomAlphanumeric(5));
        registerPage.registerUser(user);
        CheckUtils.verifyPageUrl(RegisterPage.PAGE_URL);
        registerPage.verifyErrorOnPasswordField();
    }

    @Test
    @DisplayName("Open registration page from login page")
    public void openRegistrationPageFromLoginPage() {
        LoginPage loginPage = open(LoginPage.PAGE_URL, LoginPage.class);
        loginPage.clickRegistrationLink();
        CheckUtils.verifyPageUrl(RegisterPage.PAGE_URL);
    }
}
