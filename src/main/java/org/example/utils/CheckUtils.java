package org.example.utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.junit.Assert.*;

public class CheckUtils {
    @Step("Check status code")
    public static void checkStatusCode(int expectedStatusCode, int actualStatusCode) {
        assertEquals("Wrong response status code", expectedStatusCode, actualStatusCode);
    }

    @Step("Check field \"{0}\" equality")
    public static <T> void checkFieldEquals(String fieldName, T expected, T actual) {
        assertEquals(String.format("Field \"%s\" not equals to expected", fieldName), expected, actual);
    }

    @Step("Check field \"{0}\" contains \"{1}\"")
    public static void checkFieldContainsString(String fieldName, String expectedContainedString, String actual) {
        assertTrue(
                String.format("Field \"%s\" does not contain string %s", fieldName, expectedContainedString),
                actual.contains(expectedContainedString) && StringUtils.isNotBlank(actual.replace(expectedContainedString, ""))
        );
    }

    @Step("Check field \"{0}\" is not empty")
    public static void checkFieldIsNotBlank(String fieldName, String actual) {
        assertTrue(
                String.format("Field \"%s\" is blank", fieldName),
                StringUtils.isNotBlank(actual)
        );
    }

    @Step("Check field \"{0}\" is not null")
    public static <T> void checkFieldIsNotNull(String fieldName, T actual) {
        assertNotNull(
                String.format("Field \"%s\" is null", fieldName),
                actual
        );
    }

    @Step("Check value \"{0}\" is more than {1}")
    public static void checkValueIsMoreThan(String fieldName, int lowerLimit, int actual) {
        assertTrue(
                String.format("Field \"%s\" is not more than %d", fieldName, lowerLimit),
                actual > lowerLimit
        );
    }

    ///////////////////////////
    public static void verifyErrorOnField(SelenideElement field, String errorMessage) {
        SelenideElement container = $(field).$(byXpath("./.."));
        container.shouldHave(Condition.cssClass("input_status_error"));
        $(container).$(byXpath("./../p[contains(@class,'input__error')]")).shouldHave(Condition.text(errorMessage));
    }

    public static void verifyPageUrl(String expectedUrl) {
//        if (!expectedUrl.substring(expectedUrl.length() - 1).equals("/")) {
//            expectedUrl += "/";
//        }
        webdriver().shouldHave(url(expectedUrl));
    }

}
