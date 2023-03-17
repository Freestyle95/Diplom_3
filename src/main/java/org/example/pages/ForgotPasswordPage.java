package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage extends BasePage {
    public static final String PAGE_URL = BASE_URL + "forgot-password";
    @FindBy(how = How.LINK_TEXT, using = "Войти")
    private SelenideElement loginLink;

    public void clickLoginLink() {
        loginLink.click();
    }
}
