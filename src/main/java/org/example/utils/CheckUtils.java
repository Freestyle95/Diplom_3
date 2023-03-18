package org.example.utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckUtils {
    @Step("Verify error message '{1}' on field '{0}'")
    public static void verifyErrorOnField(SelenideElement field, String errorMessage) {
        SelenideElement container = $(field).$(byXpath("./.."));
        container.shouldHave(Condition.cssClass("input_status_error"));
        $(container).$(byXpath("./../p[contains(@class,'input__error')]")).shouldHave(Condition.text(errorMessage));
    }

    @Step("Verify page URL is '{0}'")
    public static void verifyPageUrl(String expectedUrl) {
        webdriver().shouldHave(url(expectedUrl));
    }

    @Step("Verify browser local storage contains keys")
    public static void verifyLocalStorageContainsKeys(String... strings) {
        for (String item :
                strings) {
            assertTrue(String.format("Local storage does not contain key '%s'", item), localStorage().containsItem(item));
        }
    }

    @Step("Verify browser local storage does not contain keys")
    public static void verifyLocalStorageDoesNotContainKeys(String... strings) {
        for (String item :
                strings) {
            assertFalse(String.format("Local storage contains unexpected key '%s'", item), localStorage().containsItem(item));
        }
    }

    @Step("Verify element is visible")
    public static void verifyElementIsVisible(SelenideElement element) {
        $(element).shouldBe(Condition.visible);
        assertTrue("Element is not displayed", $(element).isDisplayed());
    }

    @Step("Verify element has class '{1}'")
    public static void verifyElementHasClass(SelenideElement element, String expectedCssClass) {
        $(element).shouldHave(Condition.cssClass(expectedCssClass));
    }
}
