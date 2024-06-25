package com.sovcombank.qa.asserts;

import com.sovcombank.qa.page.SovcomMainPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;
public class SovcomMainAssert extends SovcomMainPage {

    public SovcomMainAssert(WebDriver driver) {
        super(driver);
    }
}
