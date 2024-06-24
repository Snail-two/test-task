package com.sovcombank.qa;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract public class AbstractDemoQa {

    public static WebDriver driver;

    public static WebDriverWait wait;
    public static ChromeOptions options;
    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("start_page"));
    }

    @AfterClass
    public static void stopBrowser() throws InterruptedException {
        driver.quit();
    }
}
