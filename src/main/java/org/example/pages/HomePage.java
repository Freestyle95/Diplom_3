package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.example.utils.CheckUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class HomePage extends BasePage {
    public static final String PAGE_URL = BASE_URL;

    @FindBy(how = How.LINK_TEXT, using = "Личный Кабинет")
    private SelenideElement accountLink;
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement loginButton;
    @FindBy(how = How.CLASS_NAME, using = "BurgerIngredients_ingredients__menuContainer__Xu3Mo")
    private SelenideElement burgerIngredientsMenuContainer;
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']/../..")
    private SelenideElement tabsContainer;
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']/..")
    private SelenideElement bunsTab;
    @FindBy(how = How.XPATH, using = ".//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[text()='Булки']")
    private SelenideElement bunsMenuLabel;
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']/..")
    private SelenideElement saucesTab;
    @FindBy(how = How.XPATH, using = ".//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[text()='Соусы']")
    private SelenideElement saucesMenuLabel;
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']/..")
    private SelenideElement fillingsTab;
    @FindBy(how = How.XPATH, using = ".//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[text()='Начинки']")
    private SelenideElement fillingsMenuLabel;

    @Step("Click on Account Link")
    public AccountProfilePage clickAccountLink() {
        accountLink.click();
        return page(AccountProfilePage.class);
    }

    @Step("Click on Login button")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step("Click on Buns tab")
    public void clickOnBunsTab() {
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable($(bunsTab)));
        bunsTab.click();
    }

    @Step("Click on Sauces tab")
    public void clickOnSaucesTab() {
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable($(saucesTab)));
        saucesTab.click();
    }

    @Step("Click on Sauces tab")
    public void clickOnFillingsTab() {
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable($(fillingsTab)));
        fillingsTab.click();
    }

    @Step("Verify ingredients menu is visible")
    public void verifyIngredientsTabContainerIsVisible() {
        CheckUtils.verifyElementIsVisible(burgerIngredientsMenuContainer);
    }

    @Step("Verify Buns tab is active")
    public void verifyBunTabIsActive() {
        CheckUtils.verifyElementHasClass(bunsTab, "tab_tab_type_current__2BEPc");
    }

    @Step("Verify Sauces tab is active")
    public void verifySaucesTabIsActive() {
        CheckUtils.verifyElementHasClass(saucesTab, "tab_tab_type_current__2BEPc");
    }

    @Step("Verify Fillings tab is active")
    public void verifyFillingsTabIsActive() {
        CheckUtils.verifyElementHasClass(fillingsTab, "tab_tab_type_current__2BEPc");
    }

    @Step("Verify Fillings label is visible in menu")
    public void verifyFillingsAreVisibleInMenu() {
        CheckUtils.verifyElementIsVisible(fillingsMenuLabel);
    }

    @Step("Verify Buns label is visible in menu")
    public void verifyBunsAreVisibleInMenu() {
        CheckUtils.verifyElementIsVisible(bunsMenuLabel);
    }

    @Step("Verify Sauces label is visible in menu")
    public void verifySaucesAreVisibleInMenu() {
        CheckUtils.verifyElementIsVisible(saucesMenuLabel);
    }
}
