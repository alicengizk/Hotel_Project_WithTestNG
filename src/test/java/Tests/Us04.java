package Tests;

import Pages.CHPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Set;

public class Us04 {
    CHPage chPage=new CHPage();
    Actions actions=new Actions(Driver.getDriver());

    @Test
    public void test01() {
        chPage.anasayfa();
        chPage.logInButon.click();
        chPage.userName.sendKeys(ConfigReader.getProperty("chAdminUser"));
        chPage.password.sendKeys(ConfigReader.getProperty("chAdminPassword"));
        chPage.kullaniciGiris.click();
        chPage.hotelManage.click();
        chPage.hotelList.click();
        chPage.addHotel.click();
    }

    @Test (dependsOnMethods = "test01")
    public void test02() throws InterruptedException {
        chPage.hotelCode.sendKeys(ConfigReader.getProperty("code"));
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(1000);
        actions.sendKeys(ConfigReader.getProperty("hotelName"));
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(1000);
        actions.sendKeys(ConfigReader.getProperty("hotelAdres"));
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.id("Phone")).sendKeys(ConfigReader.getProperty("phone"));
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.id("Email")).sendKeys(ConfigReader.getProperty("email"));
    }


    @Test (dependsOnMethods = "test02")
    public void test03() {
        chPage.hotelType.click();
        chPage.saveButon.click();
    }

    @Test (dependsOnMethods = "test03")
    public void test04() {
        Driver.getDriver().findElement(By.xpath("//div[@class='bootbox-body']")).isDisplayed();
        Driver.getDriver().findElement(By.xpath("//button[@data-bb-handler='ok']")).click();
        chPage.hotelList.click();
    }

    @Test (dependsOnMethods = "test04")
    public void test05() throws InterruptedException {
        Driver.getDriver().findElement(By.xpath("//input[@name='IDHotel']")).sendKeys("2914");
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-sm yellow filter-submit margin-bottom']")).click();
        Thread.sleep(2000);
        String otelcode=Driver.getDriver().findElement(By.xpath("//td[@class='sorting_1']")).getText();
        String otelcode2="2222";
        System.out.println(otelcode);
        Assert.assertTrue(otelcode.contains(otelcode2));
        Driver.closeDriver();

        String ilksayfaHash = Driver.getDriver().getWindowHandle();
        Set<String> tumsayfalarhash = Driver.getDriver().getWindowHandles();
        String sonsayfahash = "";
        for (String each : tumsayfalarhash
        ) {
            if (each.equals(ilksayfaHash)) {
                sonsayfahash = each;
            }
        }

    }
}
