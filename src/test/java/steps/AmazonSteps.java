package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;
import io.cucumber.java.en.When;
import pages.Amazon;


public class AmazonSteps {
     
    Amazon amazon = new Amazon();

    

    @Given("^the user navigate to www.amazon.com$")
    public void navegateToPageStep(){
       amazon.navegatePage();
    }

    @And("^search for (.+)$")
    public void enterSearchProduct(String product){
        amazon.realizarBusqueda(product);
        amazon.clickButtonSearch();
    }

    @When("^navigate to the page number (.+)$")
    public void navigateToSecondPage(String pageNumber)throws InterruptedException{
        //amazon.getAllSearchResults();
        //amazon.printFormattedResults();
        amazon.goToPage(pageNumber);
        Thread.sleep(2000);
    }

    @And("^select the position (.+) from products$")
    public void selectThirdItem(int position){
        amazon.clickFirstImage(position);
    }
    
    @Then("^the user is able to add to the cart$")
    public void itemCanBeAddedToTheCard(){
        

    }

    @After()
    public void cerrarDriver(){
       //BasePage.closeBrowser();
    }

}    
