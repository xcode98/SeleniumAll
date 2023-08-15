package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Amazon extends BasePage{
    

    String inputSearch = "//INPUT[@id='twotabsearchtextbox']";
    String buttonSearch = "//INPUT[@id='nav-search-submit-button']";
    String imagePos1 = "//IMG[@class='s-image']/self::IMG";                      
    String addToCartButton = "";
    String addedMessageText = "";
    //String listaWebElements = "//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[1]/div[1]";
    String listaWebElements = "//div[@data-component-type='s-search-result']";
    public Amazon(){
        super(driver);
    }

    public void navegatePage(){
        navegarAGoogle("https://www.amazon.com/-/es/");
    }

    public void realizarBusqueda(String product){
        escribir(inputSearch, product);
    }

    public void clickButtonSearch(){
        clickElement(buttonSearch);
    }

    public void goToPage(String pageNumber){
        goToLinkText(pageNumber);
    }

    public void click1Element(){
        clickElement(imagePos1);
    }
    /* 
    public void addToCart (){
        clickElement(addToCartButton);
    }

    public String addedToCartMessage(){
        return textFromElement(addedMessageText);
    }*/

    public void selectPosIndex(){
        selectNthElement(listaWebElements,2);
    }


    //que el index sea variable en el feature
    public void clickFirstImage(int posicion) {
        //String listaWebElements = "//div[@data-component-type='s-search-result']";
        List<WebElement> elements = bringMeAllElements(listaWebElements);

        if (!elements.isEmpty()) {
            WebElement firstElement = elements.get(posicion);
            WebElement imageElement = firstElement.findElement(By.tagName("img"));
            imageElement.click();
        }
    }

    /* 
    public List<String> getAllSearchResults(){ //quiero obtener una lista de strings cogidas de un lista de WebElement
        List<WebElement> list = bringMeAllElements(listaWebElements); //capturamos la List <WebElement> en una variable list de tipo List <WebElemen
        List<String> stringsFromList = new ArrayList<String>(); //creame un arraylist llamado stringsFromList
        for(WebElement e:list){ //por cada elemento que encuentres en la List <WebElement> bringMeAllElements 
            stringsFromList.add(e.getText());
        }
        return stringsFromList;
    }



    public void printFormattedResults() {
        List<String> results = getAllSearchResults();
    
        for (int i = 0; i < results.size(); i++) {
            String result = results.get(i);
            System.out.println("Posición " + i + ":");
            System.out.println(result);
            System.out.println();
        }
    }*/



}
