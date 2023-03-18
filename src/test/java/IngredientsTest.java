import io.qameta.allure.junit4.DisplayName;
import org.example.Browser;
import org.example.pages.AccountProfilePage;
import org.example.pages.HomePage;
import org.example.utils.CheckUtils;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class IngredientsTest extends BaseTest {

    public IngredientsTest(Browser browser) {
        super(browser);
    }

    @Test
    @DisplayName("Navigating in ingredients menu with tabs")
    public void ingredientsTabSelection() {
        HomePage homePage = open(HomePage.PAGE_URL, HomePage.class);
        homePage.verifyIngredientsTabContainerIsVisible();
        homePage.verifyBunTabIsActive();
        homePage.verifyBunsAreVisibleInMenu();
        homePage.clickOnFillingsTab();
        homePage.verifyFillingsTabIsActive();
        homePage.verifyFillingsAreVisibleInMenu();
        homePage.clickOnSaucesTab();
        homePage.verifySaucesTabIsActive();
        homePage.verifySaucesAreVisibleInMenu();
        homePage.clickOnBunsTab();
        homePage.verifyBunTabIsActive();
        homePage.verifyBunsAreVisibleInMenu();
    }

    @Test
    @DisplayName("Open constructor from profile page")
    public void openContructorFromProfile() {
        createTestUser();
        HomePage homePage = open(HomePage.PAGE_URL, HomePage.class);
        userHelper.setLocalStorageAuthData();
        AccountProfilePage accountProfilePage = homePage.clickAccountLink();
        CheckUtils.verifyPageUrl(AccountProfilePage.PAGE_URL);
        accountProfilePage.clickOnConstruclorLink();
        CheckUtils.verifyPageUrl(HomePage.PAGE_URL);
    }
}
