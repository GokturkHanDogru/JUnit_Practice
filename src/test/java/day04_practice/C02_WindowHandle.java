package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle extends TestBase {

    @Test
    public void name() {
        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        String sayfa1Handle = driver.getWindowHandle();


        // 2- url'in 'amazon' icerdigini test edelim
        String amazonUrl = driver.getCurrentUrl();
        Assert.assertTrue(amazonUrl.contains("amazon"));


        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");

        String sayfa2Handl = driver.getWindowHandle();


        // 4- title'in 'Best Buy' icerdigini test edelim
        String bestBuyTitle = driver.getTitle();
        Assert.assertTrue(bestBuyTitle.contains("Best Buy"));


        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(sayfa1Handle);
        driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("Java"+ Keys.ENTER);


        // 6- arama sonuclarının 'Java' icerdigini test edelim
        String result = driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]")).getText();
        Assert.assertTrue(result.contains("Java"));



        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(sayfa2Handl);



        // 8- logonun gorundugunu test edelim

        WebElement bestBuyLogo = driver.findElement(By.xpath("(//img[@class=\"logo\"])[1]"));
        Assert.assertTrue(bestBuyLogo.isDisplayed());
    }
}
