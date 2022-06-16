package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.WebTableOrderPage;
import com.cydeo.pages.WebTablePage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class WebTableOrder_StepDefinitions {

    WebTablePage webTablePage = new WebTablePage();
    BasePage basePage =new BasePage();
    WebTableOrderPage webTableOrderPage = new WebTableOrderPage();


    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("webTableUrl"));
        webTablePage.login();
        basePage.order.click();
    }

    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {
        Select select = new Select(webTableOrderPage.productDropdown);
        select.selectByVisibleText(string);

    }

    @When("user enters quantity {string}")
    public void user_enters_quantity(String string) {
        webTableOrderPage.inputQuantity.sendKeys(string);


    }

    @When("user enters customer name {string}")
    public void user_enters_customer_name(String string) {
        webTableOrderPage.inputName.sendKeys(string);

    }

    @When("user enters street {string}")
    public void user_enters_street(String string) {
        webTableOrderPage.inputStreet.sendKeys(string);

    }

    @When("user enters city {string}")
    public void user_enters_city(String string) {
        webTableOrderPage.inputCity.sendKeys(string);

    }

    @When("user enters state {string}")
    public void user_enters_state(String string) {
        webTableOrderPage.inputState.sendKeys(string);

    }

    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
        webTableOrderPage.inputZip.sendKeys(string);

    }

    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String string) {
        webTableOrderPage.radioAmericanExpress.click();

    }

    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String string) {
        webTableOrderPage.inputCardNumber.sendKeys(string);

    }

    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String string) {
        webTableOrderPage.inputExpiryDate.sendKeys(string);

    }

    @When("user enters process order button")
    public void user_enters_process_order_button() {
        webTableOrderPage.buttonProcessOrder.click();

    }

    @Then("user should see {string} in first row of the web table")
    public void user_should_see_in_first_row_of_the_web_table(String string) {
        webTableOrderPage.viewAllOrders.click();
        String actualName = webTableOrderPage.recentRowNameCell.getText();
        Assert.assertEquals(string, actualName);

    }


}
