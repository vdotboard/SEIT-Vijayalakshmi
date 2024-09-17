package io.cucumber.skeleton.glue;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.cucumber.skeleton.core.Context;
import io.cucumber.skeleton.core.Manager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortableTable extends Context {
    WebDriver driver;
    public SortableTable(Manager manager) {
        super(manager);
        this.driver=manager.getDriver();
    }

    @When("I click on the sortable table link")
    public void I_click_on_the_sortable_table_link() {

        WebElement tablelink = driver.findElement(By.xpath("//a[@href='/tables']"));
        tablelink.click();
    }

    @Then("I should see the following rows in the example1 table:")
    public void i_should_see_the_following_rows_in_the_example1_table(io.cucumber.datatable.DataTable expectedTable) {
       
        WebElement table = driver.findElement(By.id("table1"));

       
        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

      
        List<Map<String, String>> expectedRows = expectedTable.asMaps(String.class, String.class);

       
        for (int i = 0; i < expectedRows.size(); i++) {
            // Find each cell in the current row
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));

    
            Map<String, String> expectedRow = expectedRows.get(i);

      
            assertEquals(expectedRow.get("Last Name"), cells.get(0).getText());
           assertEquals( expectedRow.get("First Name"), cells.get(1).getText());
         assertEquals(expectedRow.get("Email"), cells.get(2).getText());
           assertEquals(expectedRow.get("Due"), cells.get(3).getText());
            assertEquals(expectedRow.get("Web Site"), cells.get(4).getText());
        }

    }


}
