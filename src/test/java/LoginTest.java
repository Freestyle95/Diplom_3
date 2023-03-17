import org.example.models.User;
import org.example.pages.ForgotPasswordPage;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.pages.RegisterPage;
import org.example.utils.CheckUtils;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginTest extends BaseTest{
    @Test
    public void loginFromLoginPage() {
        RegisterPage registerPage = open(RegisterPage.PAGE_URL, RegisterPage.class);
        User registeredUser = registerPage.registerNewUser();
        CheckUtils.verifyPageUrl(LoginPage.PAGE_URL);

        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(registeredUser);
        CheckUtils.verifyPageUrl(HomePage.PAGE_URL);
    }
    @Test
    public void loginFromHomePageWithLoginButton() {
        HomePage homePage = open(HomePage.PAGE_URL,HomePage.class);
        homePage.clickLoginButton();
        CheckUtils.verifyPageUrl(LoginPage.PAGE_URL);
    }

    @Test
    public void loginFromRegisterPage() {
        RegisterPage registerPage = open(RegisterPage.PAGE_URL, RegisterPage.class);
        registerPage.clickLoginLink();
        CheckUtils.verifyPageUrl(LoginPage.PAGE_URL);
    }

    @Test
    public void loginFromForgotPasswordPage() {
        ForgotPasswordPage forgotPasswordPage = open(ForgotPasswordPage.PAGE_URL, ForgotPasswordPage.class);
        forgotPasswordPage.clickLoginLink();
        CheckUtils.verifyPageUrl(LoginPage.PAGE_URL);
    }
}
