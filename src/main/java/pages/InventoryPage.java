package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {

    private WebDriver driver;

    //Locators
    private By productSortDropDownLocator = By.className("product_sort_container");
    private By backpackAddButtonLocator = By.id("add-to-cart-sauce-labs-backpack");
    private By menuButtonLocator = By.xpath("//button[contains(text(),'Open Menu')]");
    private By logoutButtonLocator = By.id("logout_sidebar_link");
    private By cartButtonLocator = By.className("shopping_cart_link");
    private By cartCountLocator = By.className("shopping_cart_badge");
    private By activeSortOrder = By.xpath("//span[@class='active_option']");
    private By loginButtonLocator = By.name("login-button");

    public InventoryPage(WebDriver webDriver){
        driver = webDriver;
    }

    public void gotoCart(){
        driver.findElement(cartButtonLocator).click();
    }

    public void openMenu(){
        driver.findElement(menuButtonLocator).click();
    }

    public void clickLogout(){
        driver.findElement(logoutButtonLocator).click();
    }

    public void logout(){
        driver.findElement(menuButtonLocator).click();
        driver.findElement(logoutButtonLocator).click();
    }

    public String checkCartOrders(){
        return driver.findElement(cartCountLocator).getText();
    }
    public void sortProducts(String order){
        Select dropdown = new Select(driver.findElement(productSortDropDownLocator));
        dropdown.selectByVisibleText(order);
    }

    public String checkSortingOrder(){
        return driver.findElement(activeSortOrder).getText();
    }

    public void addProduct(String product){
        switch (product) {
            case "Sauce Labs Backpack":
                driver.findElement(backpackAddButtonLocator).click();
                break;
        }
    }

    public boolean checkLoginButton(){
        return driver.findElement(loginButtonLocator).isDisplayed();
    }
}
