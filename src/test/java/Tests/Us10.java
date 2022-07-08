package Tests;

import Pages.CHPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;

public class Us10 {
    CHPage chPage=new CHPage();
    Actions actions=new Actions(Driver.getDriver());

    @Test
    public void test01(){
        chPage.anasayfa();
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        Driver.getDriver().findElement(By.xpath("(//a[@href='/RoomDetail/676'])[2]")).click();
        Driver.getDriver().navigate().back();
        ReusableMethods.waitFor(1);
        Driver.getDriver().findElement(By.xpath("(//a[@href='/RoomDetail/675'])[2]")).click();
        Driver.getDriver().navigate().back();
        ReusableMethods.waitFor(1);
        Driver.getDriver().findElement(By.xpath("(//a[@href='/RoomDetail/674'])[2]")).click();
        Driver.getDriver().navigate().back();
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN).perform();
        Driver.getDriver().findElement(By.xpath("(//a[@href='/RoomDetail/673'])[2]")).click();
        Driver.getDriver().navigate().back();
        ReusableMethods.waitFor(1);
        Driver.getDriver().findElement(By.xpath("(//a[@href='/RoomDetail/672'])[2]")).click();
        Driver.getDriver().navigate().back();
        ReusableMethods.waitFor(1);
        Driver.getDriver().findElement(By.xpath("(//a[@href='/RoomDetail/671'])[2]")).click();
        Driver.getDriver().navigate().back();
        Driver.closeDriver();
    }

    @Test
    public void test02(){
        chPage.anasayfa();
        chPage.roomsButon.click();
        String roomTitle=Driver.getDriver().getTitle();
        Assert.assertTrue(roomTitle.contains("Rooms"));
    }

    @Test
    public void test03(){
        test02();
        ReusableMethods.waitFor(1);
        Driver.getDriver().findElement(By.id("checkin_date")).clear();
        Driver.getDriver().findElement(By.id("checkin_date")).sendKeys("7/15/2022");
        ReusableMethods.waitFor(1);
        Driver.getDriver().findElement(By.id("checkout_date")).clear();
        Driver.getDriver().findElement(By.id("checkout_date")).sendKeys("7/21/2022");
        ReusableMethods.dropDownMenuId("IDRoomType",2);
        ReusableMethods.dropDownMenuId("AdultCount",2);
        ReusableMethods.dropDownMenuId("ChildrenCount",2);
        Driver.getDriver().findElement(By.id("location")).click();
        Driver.getDriver().findElement(By.xpath("//input[@type='submit']")).click();
        String checkIndate=Driver.getDriver().findElement(By.id("checkin_date")).getText();
        System.out.println(checkIndate);
        //Assert.assertTrue(Driver.getDriver().findElement(By.id("checkin_date")).getText().contains("7/15/2022"));
    }

    @Test
    public void test04(){
        test03();
        Driver.getDriver().findElement(By.xpath("(//a[@href='/RoomDetail/2'])[3]")).click();
        Driver.getDriver().findElement(By.xpath("//a[@href='/Rooms/6']")).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        Driver.getDriver().findElement(By.xpath("//a[@href='/Rooms/7']")).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        Driver.getDriver().findElement(By.xpath("//a[@href='/Rooms/8']")).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        Driver.getDriver().findElement(By.xpath("//a[@href='/Rooms/317']")).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        Driver.getDriver().findElement(By.xpath("//a[@href='/Rooms/318']")).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        Driver.getDriver().findElement(By.xpath("//a[@href='/Rooms/319']")).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        Driver.getDriver().findElement(By.xpath("//a[@href='/Rooms/320']")).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        Driver.getDriver().findElement(By.xpath("//a[@href='/Rooms/321']")).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        Driver.getDriver().findElement(By.xpath("//a[@href='/Rooms/322']")).click();
    }

    @Test
    public void test05(){
        chPage.anasayfa();
        chPage.logInButon.click();
        Driver.getDriver().findElement(By.xpath("//span[@class='btn btn-primary py-3 px-5']")).click();
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//h1[@class='mb-4 bread']")).getText().contains("Register"));
    }

    @Test
    public void test06(){
        test05();
        Driver.getDriver().findElement(By.id("UserName")).sendKeys("alicengiz1");
        Driver.getDriver().findElement(By.id("Password")).sendKeys("Alicengiz1!");
        Driver.getDriver().findElement(By.id("Email")).sendKeys("alicengiz@gmail.com");
        Driver.getDriver().findElement(By.id("NameSurname")).sendKeys("Ali Cengiz Kasar");
        Driver.getDriver().findElement(By.id("PhoneNo")).sendKeys("111 111-1111");
        Driver.getDriver().findElement(By.id("SSN")).sendKeys("111-11-1111");
        Driver.getDriver().findElement(By.id("DrivingLicense")).sendKeys("321456771");
        ReusableMethods.dropDownMenuIdValue("IDCountry","243");
       // ReusableMethods.dropDownMenuId("IDState",0);
        Driver.getDriver().findElement(By.id("Address")).sendKeys("e gazi mah");
        Driver.getDriver().findElement(By.id("WorkingSector")).sendKeys("IT");
        Driver.getDriver().findElement(By.id("BirthDate")).sendKeys("6/3/1982");
        Driver.getDriver().findElement(By.id("btnSubmit")).click();
        Driver.getDriver().findElement(By.xpath("//button[@data-bb-handler='ok']")).click();
        
    }

}
