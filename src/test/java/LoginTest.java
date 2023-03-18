import io.qameta.allure.junit4.DisplayName;
import org.example.Browser;
import org.example.models.AuthorizationData;
import org.example.pages.ForgotPasswordPage;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.pages.RegisterPage;
import org.example.utils.CheckUtils;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest {

    public LoginTest(Browser browser) {
        super(browser);
    }

    @Test
    @DisplayName("Login from login page")
    public void loginFromLoginPage() {
        createTestUser();
        LoginPage loginPage = open(LoginPage.PAGE_URL, LoginPage.class);
        loginPage.login(user);
        CheckUtils.verifyPageUrl(HomePage.PAGE_URL);
        CheckUtils.verifyLocalStorageContainsKeys(AuthorizationData.ACCESS_TOKEN, AuthorizationData.REFRESH_TOKEN);
    }

    @Test
    @DisplayName("Login from home page")
    public void loginFromHomePageWithLoginButton() {
        HomePage homePage = open(HomePage.PAGE_URL, HomePage.class);
        homePage.clickLoginButton();
        CheckUtils.verifyPageUrl(LoginPage.PAGE_URL);
    }

    @Test
    @DisplayName("Login from register page")
    public void loginFromRegisterPage() {
        RegisterPage registerPage = open(RegisterPage.PAGE_URL, RegisterPage.class);
        registerPage.clickLoginLink();
        CheckUtils.verifyPageUrl(LoginPage.PAGE_URL);
    }

    @Test
    @DisplayName("Login from forgot-password page")
    public void loginFromForgotPasswordPage() {
        ForgotPasswordPage forgotPasswordPage = open(ForgotPasswordPage.PAGE_URL, ForgotPasswordPage.class);
        forgotPasswordPage.clickLoginLink();
        CheckUtils.verifyPageUrl(LoginPage.PAGE_URL);
    }
}
