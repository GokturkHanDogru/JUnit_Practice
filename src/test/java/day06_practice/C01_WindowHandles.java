package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandles extends TestBase {

    @Test
    public void test01() {

        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        String sayfa1Handle = driver.getWindowHandle();
        System.out.println("Sayfa 1 Handle:"+sayfa1Handle);



        // arama motoruna 'Oppo' yazıp aratın
        driver.findElement(By.id("searchData")).sendKeys("Oppo" , Keys.ENTER);
        wait(2);



        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//img[@class='lazy cardImage'])[1]")).click();
        wait(2);

        //String sayfa2Handle = driver.getWindowHandle();
        //System.out.println(sayfa2Handle);

        String sayfa2Handle  ="";
        Set<String> sayfalarHandle = driver.getWindowHandles();

        for (String w:sayfalarHandle) {

           if (!sayfa1Handle.equals(w)){
               sayfa2Handle =w;
           }

        }
        System.out.println("Sayfa 2 Handle:"+sayfa2Handle);


        // Basligin 'Oppo' icerdigini test edin.
        driver.switchTo().window(sayfa2Handle);
        Assert.assertTrue(driver.getTitle().contains("Oppo"));

        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(sayfa1Handle);
        System.out.println(driver.getTitle());

    }
}
