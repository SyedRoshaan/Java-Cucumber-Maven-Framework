package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;

    //Locators
    private By checkoutButtonLocator = By.id("checkout");
    private By finishButtonLocator = By.id("finish");
    private By continueButtonLocator = By.id("continue");
    private By cartButtonLocator = By.className("shopping_cart_link");
    private By firstnameInputLocator = By.id("first-name");
    private By lastnameInputLocator = By.id("last-name");
    private By postalInputLocator = By.id("postal-code");
    private By successMessageLocator = By.className("complete-header");

    public CheckoutPage(WebDriver webDriver){
        driver = webDriver;
    }
    public void enterFirstName(String firstname){
        driver.findElement(firstnameInputLocator).sendKeys(firstname);
    }
    public void enterLastName(String lastname){
        driver.findElement(lastnameInputLocator).sendKeys(lastname);
    }
    public void enterPostalCode(String postal){
        driver.findElement(postalInputLocator).sendKeys(postal);
    }

    public void clickCheckoutButton(){
        driver.findElement(checkoutButtonLocator).click();
    }
    public void gotoCart(){
        driver.findElement(cartButtonLocator).click();
    }
    public void continueCheckoutButton(){
        driver.findElement(continueButtonLocator).click();
    }
    public void clickFinishButton(){
        driver.findElement(finishButtonLocator).click();
    }

    public String getSuccessMessageText(){
        return driver.findElement(successMessageLocator).getText();
    }
}
