import org.example.pages.HomePage;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class DebugTest extends BaseTest{


    @Test
    public void test() {
        HomePage homePage = open(HomePage.PAGE_URL, HomePage.class);
        homePage.clickAccountLink();
    }
}
