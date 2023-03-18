package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountProfilePage extends BasePage {
    public static final String PAGE_URL = BASE_URL + "account/profile";
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement logoutButton;
    @FindBy(how = How.LINK_TEXT, using = "Конструктор")
    private SelenideElement constructorLink;

    @Step("Click on Logout button")
    public void clickLogoutButton() {
        logoutButton.click();
    }

    @Step("Click on constructor link")
    public void clickOnConstruclorLink() {
        constructorLink.click();
    }
}
