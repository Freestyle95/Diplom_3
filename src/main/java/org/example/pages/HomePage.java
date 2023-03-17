package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {
    public static final String PAGE_URL = BASE_URL;

    @FindBy(how = How.LINK_TEXT, using = "Личный Кабинет")
    private SelenideElement accountLink;
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement loginButton;

    public void clickAccountLink(){
        accountLink.click();
    }
    public void clickLoginButton(){
        loginButton.click();
    }
}
