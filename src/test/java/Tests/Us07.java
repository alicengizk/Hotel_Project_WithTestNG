package Tests;

import Pages.CHPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class Us07 {
    CHPage chPage = new CHPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test01() {
        chPage.adminGiris();
        chPage.hotelManage.click();
        chPage.hotelRooms.click();
        String expectedResult = "LIST OF HOTELROOMS";
        String actualResult = Driver.getDriver().findElement(By.xpath("//span[@class='caption-subject font-green-sharp bold uppercase']")).getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void test02() {
        test01();
        chPage.roomDetail.click();
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("(//div[@class='caption'])[1]")).getText(), "Edit Hotelroom");
        ReusableMethods.dropDownMenuId("IDHotel", 1);
        actions.doubleClick(Driver.getDriver().findElement(By.id("Code"))).sendKeys(Keys.BACK_SPACE).perform();
        Driver.getDriver().findElement(By.id("Code")).sendKeys("TestCode_01");
        actions.doubleClick(Driver.getDriver().findElement(By.id("Name"))).sendKeys(Keys.BACK_SPACE).perform();
        Driver.getDriver().findElement(By.id("Name")).sendKeys("TestName_01");
        actions.doubleClick(Driver.getDriver().findElement(By.id("Location"))).sendKeys(Keys.BACK_SPACE).perform();
        Driver.getDriver().findElement(By.id("Location")).sendKeys("TestCountry_01");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.getDriver().findElement(By.xpath("//textarea[@role='textbox']")).clear();
        ReusableMethods.waitFor(1);
        Driver.getDriver().findElement(By.xpath("//textarea[@role='textbox']")).sendKeys("TestText_01");
        Driver.getDriver().findElement(By.id("Price")).clear();
        Driver.getDriver().findElement(By.id("Price")).sendKeys("500");
        ReusableMethods.dropDownMenuId("IDGroupRoomType", 6);
        actions.doubleClick(Driver.getDriver().findElement(By.id("MaxAdultCount"))).sendKeys(Keys.BACK_SPACE).perform();
        Driver.getDriver().findElement(By.id("MaxAdultCount")).sendKeys("TestMAC_01");
        actions.doubleClick(Driver.getDriver().findElement(By.id("MaxChildCount"))).sendKeys(Keys.BACK_SPACE).perform();
        Driver.getDriver().findElement(By.id("MaxChildCount")).sendKeys("TestMCC_01");
        Driver.getDriver().findElement(By.xpath("(//button[@class='btn green'])[1]")).click();
        Driver.getDriver().findElement(By.xpath("//button[@data-bb-handler='ok']")).click();

    }

    @Test
    public void test03() {
        test02();
        Driver.getDriver().findElement(By.id("btnDelete")).click();
        Driver.getDriver().findElement(By.xpath("//button[@data-bb-handler='confirm']")).click();
        Driver.getDriver().findElement(By.xpath("//button[@data-bb-handler='ok']")).click();
    }

    @Test
    public void test04() {
        test01();
        chPage.roomDetail.click();
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("(//div[@class='caption'])[1]")).getText(), "Edit Hotelroom");
        ReusableMethods.dropDownMenuId("IDHotel", 1);
        Driver.getDriver().findElement(By.xpath("//a[@href='#tab_properties']")).click();
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        ReusableMethods.dropDownMenuId("lkpBarcodeTypes",1);
        Driver.getDriver().findElement(By.id("txtBarcodeCode")).sendKeys("TestCode_01");
        Driver.getDriver().findElement(By.id("txtBarcode")).sendKeys("TestValue_01");
        Driver.getDriver().findElement(By.xpath("(//button[@class='btn green'])[2]")).click();

    }
    @Test
    public void test05(){
        test04();
        Driver.getDriver().findElement(By.xpath("(//button[@class='btn green'])[2]")).click();
        Driver.getDriver().findElement(By.xpath("//button[@data-bb-handler='ok']")).click();
        Driver.getDriver().findElement(By.id("btnDelete")).click();
        Driver.getDriver().findElement(By.xpath("//button[@data-bb-handler='confirm']")).click();
        Driver.getDriver().findElement(By.xpath("//button[@data-bb-handler='ok']")).click();
        Driver.closeDriver();
    }


}
