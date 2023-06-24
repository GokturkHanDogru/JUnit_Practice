package day06_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_ extends TestBase {


    @Test
    public void name() {

        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        String sayfa1Handle = driver.getWindowHandle();


        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
       Actions actions = new Actions(driver);

        WebElement dilMenu = driver.findElement(By.xpath("//div[text()='EN']"));
        actions.moveToElement(dilMenu).perform();
        wait(2);



        // Change country/region butonuna basiniz
        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        // Go to website butonuna tiklayiniz
        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
    }
}
