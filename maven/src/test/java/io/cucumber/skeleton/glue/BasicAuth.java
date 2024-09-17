package io.cucumber.skeleton.glue;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.skeleton.Utils.ConfigReader;
import io.cucumber.skeleton.core.Context;
import io.cucumber.skeleton.core.Manager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.skeleton.Utils.ConfigReader;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasicAuth extends Context {
    WebDriver driver;

    public BasicAuth(Manager manager) {
        super(manager);
        this.driver = manager.getDriver();
    }
    @When("I click on the Basic Auth link")
    public void i_click_on_the_basic_auth_link() {

    }

    @When("I enter the username {string} and password {string}")
    public void i_enter_the_username_and_password(String username, String password) {
     username = ConfigReader.getProperty("username");
        password = ConfigReader.getProperty("password");
        String url = "https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";
        driver.get(url);
    }

    @Then("I should see the text {string}")
    public void i_should_see_the_text(String expectedText) {
        WebElement bodyText = driver.findElement(By.tagName("p"));
        String actualText = bodyText.getText();
        assertTrue( actualText.contains(expectedText),"The expected text was not found!");

    }

}