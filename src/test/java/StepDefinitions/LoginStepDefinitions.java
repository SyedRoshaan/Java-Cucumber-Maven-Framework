package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.LoginPage;
import utility.BrowserManager;

public class LoginStepDefinitions {

    private LoginPage loginPage;

    @Given("I am on the login page")
    public void i_am_on_the_login_page(){
        loginPage = new LoginPage(BrowserManager.getDriver());
        BrowserManager.getDriver().get("https://www.saucedemo.com/");
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertEquals(loginPage.checkProductHeading(), true);
    }

    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String errorMessage) {
        Assert.assertEquals(loginPage.checkErrorMessage(), errorMessage);
    }

    @Given("I enter {string} and {string}")
    public void iEnterAnd(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }
}