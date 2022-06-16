package com.cydeo.step_definitions;

import com.cydeo.pages.WebTablePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class WebTableStepDefinitions {


    WebTablePage webTablePage = new WebTablePage();

    @Given("user is on the login page of web table app")
    public void user_is_on_the_login_page_of_web_table_app() {
        String url = ConfigurationReader.getProperty("webTableUrl");
        Driver.getDriver().get(url);
    }

    @When("user enters username {string}")
    public void user_enters_username(String string) {
        webTablePage.usernameInput.sendKeys(string);
    }

    @When("user enters password {string}")
    public void user_enters_password(String string) {
        webTablePage.passwordInput.sendKeys(string);
    }

    @When("user clicks the login button")
    public void user_clicks_the_login_button() {
        webTablePage.loginButton.click();
    }

    @Then("user should see url contains {string}")
    public void user_should_see_url_contains(String string) {
        BrowserUtils.verifyURLContains(string);
    }


    /*
    @When("user enters username {string} password {string} and logins")
    public void userEntersUsernamePasswordAndLogins(String username, String password) {
        webTablePage.usernameInput.sendKeys(username);
        webTablePage.passwordInput.sendKeys(password + Keys.ENTER);
    }
     */


    @When("user enters username {string} password {string} and logins")
    public void userEntersUsernamePasswordAndLogins(String username, String password) {
        webTablePage.login(username, password);
    }

    @When("user enters username and password and logins")
    public void userEntersUsernameAndPasswordAndLogins() {
        webTablePage.loginWithConfig();
    }


    @When("user enters below credentials")
    public void user_enters_below_credentials(Map<String, String> credentials) {

        /*
        webTablePage.usernameInput.sendKeys(credentials.get("username"));
        webTablePage.passwordInput.sendKeys(credentials.get("password") + Keys.ENTER);
         */

        webTablePage.login(credentials.get("username"), credentials.get("password"));
    }
}
