package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class dafaq extends BasePage{
    public dafaq(){
            super(driver);
        }
    public static void main(String[] args) {
        String myFile = "CV-GianSilva.pdf";

        

        // Navegar a la página web
        driver.get("https://www.ilovepdf.com/es/pdf_a_word");

        // Leer el contenido del archivo en un objeto File
        String filePath = System.getProperty("user.dir") + "/src/test/resources/" + myFile;
        WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
        fileInput.sendKeys(filePath);

        // Esperar a que se complete la carga (ajustar el tiempo según sea necesario)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Realizar otras acciones necesarias antes de enviar el formulario
        // Por ejemplo, hacer clic en el botón para continuar con el proceso
        // driver.findElement(By.cssSelector("button#submitButton")).click();

        // Cerrar el navegador
        driver.quit();
    }

    

}