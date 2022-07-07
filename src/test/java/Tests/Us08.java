package Tests;

import Pages.CHPage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class Us08 {
    CHPage chPage = new CHPage();
    Actions actions = new Actions(Driver.getDriver());


    @Test
    public void test01() {
        chPage.adminGiris();
        chPage.hotelManage.click();
        chPage.roomReservations.click();
        chPage.addReservation.click();
        ReusableMethods.dropDownMenuId("IDUser",1);
        ReusableMethods.dropDownMenuId("IDHotelRoom",3);
        Driver.getDriver().findElement(By.id("Price")).sendKeys("1000");
        Driver.getDriver().findElement(By.id("DateStart")).sendKeys("07/23/2025");
        Driver.getDriver().findElement(By.id("DateEnd")).sendKeys("07/31/2025");
        Driver.getDriver().findElement(By.id("AdultAmount")).sendKeys("2");
        Driver.getDriver().findElement(By.id("ChildrenAmount")).sendKeys("0");
        Driver.getDriver().findElement(By.id("ContactNameSurname")).sendKeys("Ali Cengiz");
        Driver.getDriver().findElement(By.id("ContactPhone")).sendKeys("999-999-9999");
        Driver.getDriver().findElement(By.id("ContactEmail")).sendKeys("alicengiz@gmail.com");
        Driver.getDriver().findElement(By.id("Notes")).sendKeys("deneme1");
        Driver.getDriver().findElement(By.id("Approved")).click();
        Driver.getDriver().findElement(By.id("IsPaid")).click();
        Driver.getDriver().findElement(By.id("btnSubmit")).click();
        Driver.getDriver().findElement(By.xpath("//button[@data-bb-handler='ok']")).click();
        Driver.closeDriver();

    }
}
