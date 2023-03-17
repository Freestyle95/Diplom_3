import org.example.utils.Browser;
import org.example.utils.SelenideConfiguration;
import org.junit.Before;

//@RunWith(Parameterized.class)
public class BaseTest {
    @Before
    public void setUp() throws Exception {
        SelenideConfiguration.setBrowser(Browser.CHROME);
    }
//    protected String browser;

//    public BaseTest(String browser) {
//        this.browser = browser;
//    }
//
//    @Parameterized.Parameters
//    protected Object[][] getBrowser() {
//        return new Object[][]{
//                {"chrome"},
//                {"yandex"},
//                {"firefox"}
//        };
//    }
}
