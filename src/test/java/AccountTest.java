import io.qameta.allure.junit4.DisplayName;
import org.example.Browser;
import org.example.models.AuthorizationData;
import org.example.pages.AccountProfilePage;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.utils.CheckUtils;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class AccountTest extends BaseTest {

    public AccountTest(Browser browser) {
        super(browser);
    }

    @Test
    @DisplayName("Open account profile page from home page")
    public void openAccountProfilePage() {
        createTestUser();
        HomePage homePage = open(HomePage.PAGE_URL, HomePage.class);
        userHelper.setLocalStorageAuthData();
        homePage.clickAccountLink();
        CheckUtils.verifyPageUrl(AccountProfilePage.PAGE_URL);
    }

    @Test
    @DisplayName("Logout from profile page")
    public void logoutFromProfilePage() {
        createTestUser();
        HomePage homePage = open(HomePage.PAGE_URL, HomePage.class);
        userHelper.setLocalStorageAuthData();
        AccountProfilePage accountProfilePage = homePage.clickAccountLink();

        accountProfilePage.clickLogoutButton();
        CheckUtils.verifyPageUrl(LoginPage.PAGE_URL);
        CheckUtils.verifyLocalStorageDoesNotContainKeys(AuthorizationData.ACCESS_TOKEN, AuthorizationData.REFRESH_TOKEN);
    }
}
