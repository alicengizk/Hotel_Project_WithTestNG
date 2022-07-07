package Tests;

import Pages.CHPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class Us09 {
    CHPage chPage = new CHPage();
    Actions actions = new Actions(Driver.getDriver());


    @Test
    public void test01() {
        chPage.adminGiris();
        chPage.hotelManage.click();
        chPage.roomReservations.click();
        Driver.getDriver().findElement(By.xpath("//input[@name='ContactNameSurname']")).sendKeys("Ali Cengiz");
        actions.sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER).perform();
        Driver.getDriver().findElement(By.xpath("//a[@href='./RoomReservationAdmin/Edit?Id=1905']")).click();
        Driver.getDriver().findElement(By.id("DateStart")).clear();
        Driver.getDriver().findElement(By.id("DateStart")).sendKeys("12/12/2022");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        Driver.getDriver().findElement(By.xpath("(//button[@class='btn green'])[1]")).click();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Driver.getDriver().findElement(By.xpath("//a[@href='#tab_properties']")).click();
        ReusableMethods.dropDownMenuId("lkpBarcodeTypes", 1);
        Driver.getDriver().findElement(By.id("txtBarcodeCode")).sendKeys("999");
        Driver.getDriver().findElement(By.id("txtBarcode")).sendKeys("Iyi Tatiller");
        Driver.getDriver().findElement(By.xpath("(//button[@class='btn green'])[2]")).click();
        Driver.getDriver().findElement(By.id("btnDelete")).click();
        Driver.closeDriver();
    }
}
