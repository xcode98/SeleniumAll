package steps;

import org.junit.Assert;
import io.cucumber.java.en.*;
import pages.TradeMePage;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class TradeMeSteps {
    
    // private ValidatableResponse json;
    // private static RequestSpecification request;
    // private Response response;

    TradeMePage tm = new TradeMePage();
    
    @Given("^I navigate to the TradeMe Motor page$")
    public void navigateToTradeMeMotor(){
        tm.navigateToTradeMeMotor();
    }

    @When("^I select the car make (.+)$")
    public void selectMake(String make){
        tm.selectMakeFromDropdown(make);
    }

    @Then("^I can see it has (.+) records in the results$")
    public void printAmount(String expectedAmountOfResults){
        tm.clickSearch();
        Assert.assertTrue(tm.resultsAmount().contains(expectedAmountOfResults));            
        Assert.assertEquals("Showing "+expectedAmountOfResults+" results", tm.resultsAmount());
    }

    @Then("^I can verify that the number of car makes is (\\d+)$")
    public void returnAmountofMakes(int makeAmount){
        int expectedAmount = makeAmount;
        int actualAmount = tm.makeDrownSize();
        Assert.assertEquals(expectedAmount, actualAmount);
    }

    @Given("^I sen the request to the endpoint$")
    public void sendGETRequest(){
        //request = given().log().all().param("","");
    }

    @Then("^I can see there are (\\d+) car makes$")
    public void validateAmountOfMakes(int expectedMakeAmount){
        //response = request.when().get()
    }

}
