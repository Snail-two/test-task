package com.sovcombank.qa;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract public class AbstractSovcom {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static ChromeOptions options;

    public static Logger logger = Logger.getLogger(AbstractSovcom.class.getName());

    @BeforeAll
    public static void setup() {
        logger.info("Открытие браузера");
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("sovcom"));
    }

    @AfterAll
    public static void stopBrowser() {
        logger.info("Закрытие браузера");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}