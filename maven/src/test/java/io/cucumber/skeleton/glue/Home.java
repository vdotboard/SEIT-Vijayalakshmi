package io.cucumber.skeleton.glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.cucumber.skeleton.core.Context;
import io.cucumber.skeleton.core.Manager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Home extends Context {

  public Home(Manager manager) {
    super(manager);
  }
  WebDriver driver;
  List<String> actualExamplesList = new ArrayList<>();

  @And("an example Home Page step")
  public void exampleHomePageStep() {
    this.driver=manager.getDriver();

  }

  @When("I retrieve the list of examples")
  public void i_retrieve_the_list_of_examples() {

    List<WebElement> exampleLinks = driver.findElements(By.cssSelector("ul li a"));
    for (WebElement link : exampleLinks) {
      actualExamplesList.add(link.getText().trim());
    }
  }

  @Then("I should see the following examples:")
  public void i_should_see_the_following_examples(List<String> expectedExamplesList) {
    for (String expected : expectedExamplesList) {
      assertTrue(actualExamplesList.contains(expected),
              "The expected example '" + expected + "' was not found in the actual examples list!");
    }

  }


}
