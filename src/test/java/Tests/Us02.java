package Tests;

import Pages.CHPage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import javax.swing.*;

public class Us02 {
    CHPage chPage=new CHPage();
    Actions actions=new Actions(Driver.getDriver());

    @Test
    public void test01() {
        chPage.anasayfa();
        chPage.logInButon.isDisplayed();
        chPage.logInButon.click();
    }

    @Test (dependsOnMethods = "test01")
    public void test02() {
        chPage.userName.isDisplayed();
        chPage.userName.sendKeys(ConfigReader.getProperty("chAdminUser"));
    }

    @Test (dependsOnMethods = "test02")
    public void test03() {
        chPage.password.isDisplayed();
        chPage.password.sendKeys(ConfigReader.getProperty("chAdminPassword"));
    }

    @Test (dependsOnMethods = "test03")
    public void test04() {
        chPage.kullaniciGiris.click();
    }

    @Test (dependsOnMethods = "test04")
    public void test05() {
        Driver.getDriver().findElement(By.xpath("//span[@class='caption-subject font-green-sharp bold uppercase']")).isDisplayed();
        Driver.closeDriver();
    }
}
