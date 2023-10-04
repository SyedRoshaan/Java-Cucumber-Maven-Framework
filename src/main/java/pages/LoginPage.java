package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    // Locators
    private By usernameInputLocator = By.name("user-name");
    private By passwordInputLocator = By.name("password");
    private By loginButtonLocator = By.name("login-button");
    private By productHeadingLocator = By.xpath("//span[contains(text(),'Product')]");
    private By errorMessageLocator = By.xpath("//h3[@data-test='error']");

    // Constructor
    public LoginPage(WebDriver webDriver) {
        driver = webDriver;
    }

    // Methods
    public void enterUsername(String email) {
        driver.findElement(usernameInputLocator).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInputLocator).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButtonLocator).click();
    }

    public boolean checkProductHeading(){
        return driver.findElement(productHeadingLocator).isDisplayed();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String checkErrorMessage(){
        return driver.findElement(errorMessageLocator).getText();
    }
}
