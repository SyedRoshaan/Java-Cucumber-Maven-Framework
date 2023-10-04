package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BrowserManager {
    private static WebDriver webDriver;

    public static WebDriver getDriver(){
        return webDriver;
    }
    public static void setDriver(WebDriver driver){
        webDriver = driver;
    }

    public static void setupDriver(String URL) throws InterruptedException {
        WebDriver driver;

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        setDriver(driver);
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        Thread.sleep(1500);
        getDriver().get(URL);
    }

    public static void closeDriver(){
        getDriver().close();
    }
}
