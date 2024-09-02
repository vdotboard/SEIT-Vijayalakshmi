package io.cucumber.skeleton.glue;

import io.cucumber.java.en.Given;
import io.cucumber.skeleton.core.Context;
import io.cucumber.skeleton.core.Manager;

public class Navigation extends Context {

  public Navigation(Manager manager) {
    super(manager);
  }

  @Given("^the page under test is '(.+)'$")
  public void navToPage(String url) {
    manager.getDriver().get(url);
    stash("exampleKey1", "exampleValue1");
  }
}