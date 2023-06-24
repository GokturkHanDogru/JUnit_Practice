package day08_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C02_FilesDowland extends TestBase {


    @Test
    public void test01() {
        // 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");
        wait(2);


        File silinecekDosya = new File("C:\\Users\\goktu\\Downloads\\some-file.txt");
        silinecekDosya.delete();




        // some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//a[@href=\"download/some-file.txt\"]")).click();
        wait(3);

        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz

        //C:\Users\goktu\Downloads\some-file.txt
        //Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\goktu\\Downloads\\some-file.txt")));

        //daha dinamik hale getirelim
        //C:\Users\goktu        \Downloads\some-file.txt

        String  farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\some-file.txt";
        String dosyaYolu = farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
