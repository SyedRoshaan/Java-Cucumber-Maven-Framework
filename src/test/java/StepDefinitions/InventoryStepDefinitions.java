package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.InventoryPage;
import utility.BrowserManager;

public class InventoryStepDefinitions {

    private InventoryPage inventoryPage;

    @Given("I am on inventory page")
    public void iAmOnInventoryPage() {
        inventoryPage = new InventoryPage(BrowserManager.getDriver());
    }

    @When("I sort the products by {string}")
    public void iSortTheProductsBy(String order) {
        inventoryPage.sortProducts(order);
    }

    @Then("Products are sorted according to the {string}")
    public void productsAreSortedAccordingToThe(String order) {
        Assert.assertEquals(inventoryPage.checkSortingOrder(), order);
    }

    @When("I add {string} to the cart")
    public void iAddToTheCart(String product) {
        inventoryPage.addProduct(product);
    }

    @Then("Product is successfully added to the cart")
    public void productIsSuccessfullyAddedToTheCart() {

        int numberOfOrders = Integer.parseInt(inventoryPage.checkCartOrders());
        Assert.assertTrue(numberOfOrders > 0);
    }

    @When("I click side menu")
    public void iClickSideMenu() {
        inventoryPage.openMenu();
    }

    @And("I click logout button")
    public void iClickLogoutButton() {
        inventoryPage.clickLogout();
    }

    @Then("I should be logged out successfully")
    public void iShouldBeLoggedOutSuccessfully() {
        inventoryPage.checkLoginButton();
    }
}
