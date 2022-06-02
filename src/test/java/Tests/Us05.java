package Tests;

import Pages.CHPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import javax.swing.*;
import java.util.List;
import java.util.Set;

public class Us05 {
    CHPage chPage = new CHPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test01() {
        chPage.anasayfa();
        chPage.logInButon.click();
        chPage.userName.sendKeys(ConfigReader.getProperty("chAdminUser"));
        chPage.password.sendKeys(ConfigReader.getProperty("chAdminPassword"));
        chPage.kullaniciGiris.click();
        chPage.hotelManage.click();
        chPage.hotelList.click();
        Driver.getDriver().findElement(By.xpath("(//a[@href='#'])[1]")).isDisplayed();

    }

    @Test(dependsOnMethods = "test01")
    public void test02() {
        Driver.getDriver().findElement(By.xpath("(//a[@class='btn btn-xs default'])[1]")).click();
        String ilksayfaHash = Driver.getDriver().getWindowHandle();
        Set<String> tumsayfalarhash = Driver.getDriver().getWindowHandles();
        String sonsayfahash = "";
        for (String each : tumsayfalarhash
        ) {
            if (!each.equals(ilksayfaHash)) {
                sonsayfahash = each;
            }

        }
        Driver.getDriver().switchTo().window(sonsayfahash);
        Driver.getDriver().findElement(By.xpath("(//div[@class='caption'])[1]")).isDisplayed();
    }

    @Test(dependsOnMethods = "test02")
    public void test03() throws InterruptedException {
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.id("Code")).sendKeys(Keys.SHIFT,Keys.HOME,Keys.DELETE);
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.id("Code")).sendKeys("1234");
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.id("Name")).sendKeys(Keys.SHIFT,Keys.HOME,Keys.DELETE);
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.id("Name")).sendKeys("Name");
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.id("Address")).sendKeys(Keys.SHIFT,Keys.HOME,Keys.DELETE);
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.id("Address")).sendKeys("adres1");
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.id("Phone")).sendKeys(Keys.SHIFT,Keys.HOME,Keys.DELETE);
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.id("Phone")).sendKeys("555555555");
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.id("Email")).sendKeys(Keys.SHIFT,Keys.HOME,Keys.DELETE);
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.id("Email")).sendKeys("123@gmail.xom");
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.xpath("(//select[@class='form-control input-lg required'])[1]//option[@value='1']")).click();
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.xpath("(//button[@class='btn green'])[1]")).click();
    }

    @Test(dependsOnMethods = "test03")
    public void test04() {
        Driver.getDriver().findElement(By.xpath("//div[@class='bootbox-body']")).isDisplayed();
        Driver.getDriver().findElement(By.xpath("//button[@data-bb-handler='ok']")).click();
        Driver.getDriver().findElement(By.xpath("(//div[@class='caption'])[1]")).isDisplayed();
    }

    @Test(dependsOnMethods = "test04")
    public void test05() {
        Driver.getDriver().findElement(By.id("btnDelete")).click();
        Driver.getDriver().findElement(By.xpath("//div[@class='bootbox-body']")).isDisplayed();
    }

    @Test (dependsOnMethods = "test05")
    public void test06() {
        Driver.getDriver().findElement(By.xpath("//button[@data-bb-handler='confirm']")).click();
        Driver.getDriver().findElement(By.id("UserName")).sendKeys(ConfigReader.getProperty("chAdminUser"));
        Driver.getDriver().findElement(By.id("Password")).sendKeys(ConfigReader.getProperty("chAdminPassword"));
        Driver.getDriver().findElement(By.xpath("//button[@type='submit']")).click();

    }
}
