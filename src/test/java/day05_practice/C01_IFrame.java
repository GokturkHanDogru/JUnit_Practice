package day05_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.webaudio.WebAudio;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.crypto.KeyAgreementSpi;

public class C01_IFrame extends TestBase {

    @Test
    public void iframe() {
        // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
        driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/");


        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // Videoyu izlemek icin Play tusuna basiniz
        WebElement iframe = driver.findElement(By.xpath("//iframe[@src=\"https://www.youtube.com/embed/x3kfyZJhC3U?rel=0&showinfo=0\"]"));
        driver.switchTo().frame(iframe);

        WebElement button = driver.findElement(By.xpath("//button[@class=\"ytp-large-play-button ytp-button ytp-large-play-button-red-bg\"]"));
        button.click();

        wait(2);
        // videoyu durdurunuz
        driver.findElement(By.xpath("//button[@class=\"ytp-play-button ytp-button\"]")).click();


        // videoyu tam ekran yapınız
        driver.findElement(By.xpath("//button[@class=\"ytp-fullscreen-button ytp-button\"]")).click();


        // videoyu calıstırınız
       wait(2);
        driver.findElement(By.xpath("//button[@class=\"ytp-play-button ytp-button\"]")).click();


        // videoyu kucultunuz
        driver.findElement(By.xpath("//button[@class=\"ytp-fullscreen-button ytp-button\"]")).click();

        // videoyu durdurunuz
        wait(2);
        driver.findElement(By.xpath("//button[@class=\"ytp-play-button ytp-button\"]")).click();


        // Videoyu calistirdiginizi test ediniz
        WebElement youtube = driver.findElement(By.xpath("//a[@class=\"ytp-youtube-button ytp-button yt-uix-sessionlink\"]"));
        Assert.assertTrue(youtube.isDisplayed());


        // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz
        driver.switchTo().defaultContent();
        wait(2);
        actions.sendKeys(Keys.PAGE_UP).perform();
        wait(2);
        WebElement title = driver.findElement(By.xpath("//h1[text()='jQuery Flexy Plugin Demos']"));
        Assert.assertTrue(title.isDisplayed());
    }
}
