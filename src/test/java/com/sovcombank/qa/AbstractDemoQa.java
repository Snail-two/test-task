package com.sovcombank.qa;

import lombok.Getter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;
@Getter
//TODO: добавить логирование
abstract public class AbstractDemoQa {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static ChromeOptions options;

    public String randomNumber(){
        Random random = new Random();
        long randomTenDigitNumber = 1000000000L + random.nextInt((int) 9000000000L);
        return String.valueOf(randomTenDigitNumber);
    }

    @BeforeAll
    public static void setup() {
        // определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        // настройка опций Chrome
        options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        // создание экземпляра драйвера с опциями
        driver = new ChromeDriver(options);
        // создание экземпляра WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // окно разворачивается на полный экран
        driver.manage().window().maximize();
        // получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("start_page"));
    }

    @AfterAll
    public static void stopBrowser() throws InterruptedException {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
