package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablePage {

    public WebTablePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "input[name='username']")
    public WebElement usernameInput;

    @FindBy(css = "input[name='password']")
    public WebElement passwordInput;

    @FindBy(css = "button[type = 'submit']")
    public WebElement loginButton;


    /**
     * No parameters
     * When we call this method it will directly login using
     *
     * username : Test
     * password : Tester
     */
    public void login(){
        this.usernameInput.sendKeys("Test");
        this.passwordInput.sendKeys("Tester");
        this.loginButton.click();
    }


    /**
     * This method accepts two arguments and logins
     * @param username
     * @param password
     */
    public void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }


    /**
     *This method will log in using credentials from
     * configuration.properties
     */
    public void loginWithConfig(){
        String username = ConfigurationReader.getProperty("webTableUsername");
        String password = ConfigurationReader.getProperty("webTablePassword");
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }


}
