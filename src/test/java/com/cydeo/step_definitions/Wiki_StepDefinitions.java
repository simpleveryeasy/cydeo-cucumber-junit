package com.cydeo.step_definitions;

import com.cydeo.pages.WikipediaPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Wiki_StepDefinitions {

    WikipediaPage wikipediaPage =new WikipediaPage();

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org");
    }


    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String string) {
        wikipediaPage.searchBox.sendKeys(string);
    }


    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikipediaPage.searchButton.click();
    }


    @Then("User sees {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String string) {
        //verify actual title contains expected string
        Assert.assertTrue(Driver.getDriver().getTitle().contains(string));

    }

    @Then("User sees {string} is in the main header")
    public void user_sees_is_in_the_main_header(String arg0) {
        Assert.assertTrue(wikipediaPage.mainHeader.isDisplayed());

        Assert.assertTrue(wikipediaPage.mainHeader.getText().equals(arg0));

    }

    @Then("User sees {string} is in the image header")
    public void user_sees_is_in_the_image_header(String string) {

        Assert.assertTrue(wikipediaPage.imageHeader.getText().equals(string));
    }
}
