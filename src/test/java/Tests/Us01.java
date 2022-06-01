package Tests;

import Pages.CHPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class Us01 {
    CHPage chPage=new CHPage();
    Actions actions=new Actions(Driver.getDriver());


    @Test
    public void test01() {
        chPage.anasayfa();
        chPage.aboutButon.isDisplayed();
        chPage.blogButon.isDisplayed();
        chPage.contactButon.isDisplayed();
        chPage.homeButon.isDisplayed();
        chPage.logInButon.isDisplayed();
        chPage.restaurantButon.isDisplayed();
        chPage.roomsButon.isDisplayed();
    }

    @Test (dependsOnMethods = "test01")
    public void test02()  {
        chPage.roomsButon.click();
        Driver.getDriver().navigate().back();
        chPage.restaurantButon.click();
        Driver.getDriver().navigate().back();
        chPage.logInButon.click();
        Driver.getDriver().navigate().back();
        chPage.contactButon.click();
        Driver.getDriver().navigate().back();
        chPage.blogButon.click();
        Driver.getDriver().navigate().back();
        chPage.aboutButon.click();
        Driver.getDriver().navigate().back();
    }

    @Test (dependsOnMethods = "test02")
    public void test03() throws InterruptedException {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.xpath("//input[@class='form-control checkin_date']")).click();
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.xpath("//tbody//tr[2]//td[3]")).click();
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.id("checkout_date")).click();
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.xpath("//tbody//tr[3]//td[2]")).click();
        Driver.getDriver().findElement(By.xpath("//select[@id='IDRoomType']//option[@value='7']")).click();
        Driver.getDriver().findElement(By.xpath("//select[@id='AdultCount']//option[@value='2']")).click();
    }

    @Test (dependsOnMethods = "test03")
    public void test04() throws InterruptedException {
        Driver.getDriver().findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(1000);
        Driver.getDriver().navigate().back();
    }

    @Test (dependsOnMethods = "test04")
    public void test05()  {
        Driver.getDriver().findElement(By.xpath("(//h2[@class='mb-4'])[1]")).isDisplayed();

    }

    @Test (dependsOnMethods = "test05")
    public void test06() throws InterruptedException {
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.xpath("(//a[@href='rooms.html'])[1]")).click();
        Driver.getDriver().navigate().back();
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.xpath("(//a[@href='rooms.html'])[2]")).click();
        Driver.getDriver().navigate().back();
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.xpath("(//a[@href='rooms.html'])[3]")).click();
        Driver.getDriver().navigate().back();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.getDriver().findElement(By.xpath("(//a[@href='rooms.html'])[4]")).click();
        Driver.getDriver().navigate().back();
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.xpath("(//a[@href='rooms.html'])[5]")).click();
        Driver.getDriver().navigate().back();
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.xpath("(//a[@href='rooms.html'])[6]")).click();
        Driver.getDriver().navigate().back();
    }

    @Test (dependsOnMethods = "test06")
    public void test07() throws InterruptedException {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.xpath("(//button[@role='button'])[1]")).click();
        Driver.getDriver().findElement(By.xpath("(//button[@role='button'])[2]")).click();
        Driver.getDriver().findElement(By.xpath("(//button[@role='button'])[3]")).click();
        Driver.getDriver().findElement(By.xpath("(//button[@role='button'])[4]")).click();
        Driver.getDriver().findElement(By.xpath("(//button[@role='button'])[5]")).click();
    }

    @Test (dependsOnMethods = "test07")
    public void test08() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.getDriver().findElement(By.xpath("//a[@href='/Content/ContentDetails/12']")).click();
        Driver.getDriver().navigate().back();
        Driver.getDriver().findElement(By.xpath("//a[@href='/Content/ContentDetails/11']")).click();
        Driver.getDriver().navigate().back();
        Driver.getDriver().findElement(By.xpath("//a[@href='/Content/ContentDetails/10']")).click();
        Driver.getDriver().navigate().back();
        Driver.getDriver().findElement(By.xpath("//a[@href='/Content/ContentDetails/9']")).click();
        Driver.getDriver().navigate().back();
    }

    @Test (dependsOnMethods = "test08")
    public void test09() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.getDriver().findElement(By.xpath("(//div[@class='icon d-flex justify-content-center'])[1]")).click();
        Driver.getDriver().findElement(By.xpath("//button[@title='Close (Esc)']")).click();
        Driver.getDriver().findElement(By.xpath("(//div[@class='icon d-flex justify-content-center'])[2]")).click();
        Driver.getDriver().findElement(By.xpath("//button[@title='Close (Esc)']")).click();
        Driver.getDriver().findElement(By.xpath("(//div[@class='icon d-flex justify-content-center'])[3]")).click();
        Driver.getDriver().findElement(By.xpath("//button[@title='Close (Esc)']")).click();
        Driver.getDriver().findElement(By.xpath("(//div[@class='icon d-flex justify-content-center'])[4]")).click();
        Driver.getDriver().findElement(By.xpath("//button[@title='Next (Right arrow key)']")).click();
        Driver.getDriver().findElement(By.xpath("//button[@title='Previous (Left arrow key)']")).click();
        Driver.getDriver().findElement(By.xpath("//button[@title='Close (Esc)']")).click();
    }

    @Test (dependsOnMethods = "test09")
    public void test10() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.getDriver().findElement(By.xpath("(//h2[@class='ftco-heading-2'])[1]")).isDisplayed();
        Driver.getDriver().findElement(By.xpath("(//h2[@class='ftco-heading-2'])[2]")).isDisplayed();
        Driver.getDriver().findElement(By.xpath("(//h2[@class='ftco-heading-2'])[3]")).isDisplayed();
        Driver.getDriver().findElement(By.xpath("(//h2[@class='ftco-heading-2'])[4]")).isDisplayed();
        Driver.closeDriver();
    }

}
