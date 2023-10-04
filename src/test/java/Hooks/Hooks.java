package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utility.BrowserManager;

import java.io.ByteArrayInputStream;

public class Hooks {
    @BeforeAll
    public static void setup() throws InterruptedException {
        BrowserManager.setupDriver("https://www.saucedemo.com/");
    }

    @After
    public void takeScreenshot(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)BrowserManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
        }
    }

    @AfterAll
    public static void cleanUp(){
        BrowserManager.closeDriver();
    }
}
