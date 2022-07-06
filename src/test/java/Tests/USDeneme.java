package Tests;

import Pages.CHPage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class USDeneme {
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
        ReusableMethods.switchWindowIndex(1);
        Driver.getDriver().findElement(By.xpath("(//div[@class='caption'])[1]")).isDisplayed();
    }
}
