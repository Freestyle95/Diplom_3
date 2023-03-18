import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.example.Browser;
import org.example.SelenideConfig;
import org.example.models.AuthorizationData;
import org.example.models.User;
import org.example.utils.UserHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public abstract class BaseTest {
    protected UserHelper userHelper;
    protected User user;
    protected Browser browser;
    private List<AuthorizationData> createdUsers;

    public BaseTest(Browser browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "Browser: {0}")
    public static Object[][] getBrowser() {
        return new Object[][]{{Browser.CHROME}, {Browser.FIREFOX}, {Browser.YANDEX}};
    }

    @Before
    public void setUp() throws Exception {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        SelenideConfig.setBrowser(browser);
        userHelper = new UserHelper();
        createdUsers = new ArrayList<>();
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
        userHelper.deleteUsersPostcondition(createdUsers);
    }

    @Step("Precondition: Create user for test")
    public void createTestUser() {
        userHelper.createAndLoginUser();
        user = userHelper.authorizationData.getUser();
        createdUsers.add(userHelper.authorizationData);
    }
}
