package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_DropDownMenu extends TestBase {

    @Test
    public void name() {
        // https://www.amazon.com/ sayfasina gidin

        driver.get("https://www.amazon.com/");



        // dropdown'dan "Books" secenegini secin

        //Drop Dowwn 3 adimda handle edilir

        // 1. DDM locate edilir
        WebElement ddm = driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]"));


        // 2. Select objesi olusturulur
        Select select = new Select(ddm);

        // 3. Opsiyonlardan biri secilir
        select.selectByVisibleText("Books");



        // arama cubuguna "Java" aratın
        driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("Java"+ Keys.ENTER);



        // arama sonuclarinin Java icerdigini test edin
        String result = driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]")).getText();
        Assert.assertTrue(result.contains("Java"));
    }
}
