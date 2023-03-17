import org.apache.commons.lang3.RandomStringUtils;
import org.example.models.User;
import org.example.pages.LoginPage;
import org.example.pages.RegisterPage;
import org.example.utils.CheckUtils;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class RegisterTest extends BaseTest {

    @Test
    public void successfulRegistration() {
        RegisterPage registerPage = open(RegisterPage.PAGE_URL, RegisterPage.class);
        registerPage.registerNewUser();
        CheckUtils.verifyPageUrl(LoginPage.PAGE_URL);
    }

    @Test
    public void incorrectPasswordError() {
        RegisterPage registerPage = open(RegisterPage.PAGE_URL, RegisterPage.class);
        User user = User.generateRandomUser();
        user.setPassword(RandomStringUtils.randomAlphanumeric(5));
        registerPage.registerWithCredentials(user);
        CheckUtils.verifyPageUrl(RegisterPage.PAGE_URL);
        registerPage.verifyErrorOnPasswordField();
    }
}
