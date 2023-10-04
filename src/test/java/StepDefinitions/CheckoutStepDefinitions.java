package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CheckoutPage;
import utility.BrowserManager;

public class CheckoutStepDefinitions {

    private CheckoutPage checkoutPage;
    @Given("I am on checkout page")
    public void iAmOnCheckoutPage() {
        checkoutPage = new CheckoutPage(BrowserManager.getDriver());
    }

    @When("I enter {string}, {string} and {string}")
    public void iEnterAnd(String firstName, String lastName, String postalCode) {
        checkoutPage.enterFirstName(firstName);
        checkoutPage.enterLastName(lastName);
        checkoutPage.enterPostalCode(postalCode);
    }

    @When("I click checkout button")
    public void iClickCheckoutButton() {
        checkoutPage.clickCheckoutButton();
    }

    @And("I click continue button")
    public void iClickContinueButton() {
        checkoutPage.continueCheckoutButton();
    }

    @And("I click finish button")
    public void iClickFinishButton() {
        checkoutPage.clickFinishButton();
    }

    @Then("Order is placed successfully")
    public void orderIsPlacedSuccessfully() {
        Assert.assertEquals(checkoutPage.getSuccessMessageText(), "Thank you for your order!");
    }

    @When("I go to cart")
    public void iGoToCart() {
        checkoutPage.gotoCart();
    }
}
