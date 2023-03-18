package org.example;

import com.codeborne.selenide.WebDriverRunner;
import jdk.jshell.spi.ExecutionControl;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelenideConfig {
    public static void setBrowser(Browser browser) throws ExecutionControl.NotImplementedException {
        if (browser == Browser.FIREFOX) {
            System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\firefoxWebDriver\\geckodriver.exe");
            WebDriverRunner.setWebDriver(new FirefoxDriver());
        } else if (browser == Browser.CHROME) {
            System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromeWebDriver\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriverRunner.setWebDriver(new ChromeDriver(options));
        } else if (browser == Browser.YANDEX) {
            System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\yandexWebDriver\\yandexdriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriverRunner.setWebDriver(new ChromeDriver(options));
        } else {
            throw new ExecutionControl.NotImplementedException(String.format("Browser '%s' is not supported", browser.toString()));
        }
    }
}

