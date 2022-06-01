package Tests;

import Pages.CHPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class Us03 {
    CHPage chPage=new CHPage();
    Actions actions=new Actions(Driver.getDriver());

    @Test
    public void test01() {
        chPage.anasayfa();
        chPage.logInButon.click();
        chPage.createAccount.click();
        Driver.getDriver().findElement(By.xpath("//h1[@class='mb-4 bread']")).isDisplayed();
    }

    @Test (dependsOnMethods = "test01")
    public void test02() {
        Driver.getDriver().findElement(By.id("UserName")).isDisplayed();
        Driver.getDriver().findElement(By.id("Password")).isDisplayed();
        Driver.getDriver().findElement(By.id("Email")).isDisplayed();
        Driver.getDriver().findElement(By.id("NameSurname")).isDisplayed();
        Driver.getDriver().findElement(By.id("PhoneNo")).isDisplayed();
        Driver.getDriver().findElement(By.id("SSN")).isDisplayed();
        Driver.getDriver().findElement(By.id("DrivingLicense")).isDisplayed();
        Driver.getDriver().findElement(By.id("IDCountry")).isDisplayed();
        Driver.getDriver().findElement(By.id("IDState")).isDisplayed();
        Driver.getDriver().findElement(By.id("Address")).isDisplayed();
        Driver.getDriver().findElement(By.id("WorkingSector")).isDisplayed();
        Driver.getDriver().findElement(By.id("BirthDate")).isDisplayed();
    }

    @Test (dependsOnMethods = "test02")
    public void test03() throws InterruptedException {
        Driver.getDriver().findElement(By.id("UserName")).sendKeys(ConfigReader.getProperty("username"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.getDriver().findElement(By.id("Password")).sendKeys(ConfigReader.getProperty("password"));
        Driver.getDriver().findElement(By.id("Email")).sendKeys(ConfigReader.getProperty("email"));
        Driver.getDriver().findElement(By.id("NameSurname")).sendKeys(ConfigReader.getProperty("fullname"));
        Driver.getDriver().findElement(By.id("PhoneNo")).sendKeys(ConfigReader.getProperty("phone"));
        Driver.getDriver().findElement(By.id("SSN")).sendKeys(ConfigReader.getProperty("ssn"));
        Driver.getDriver().findElement(By.id("DrivingLicense")).sendKeys(ConfigReader.getProperty("driver"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.getDriver().findElement(By.id("IDCountry")).sendKeys(ConfigReader.getProperty("country"));
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.id("IDState")).sendKeys(ConfigReader.getProperty("state"));
        Driver.getDriver().findElement(By.id("Address")).sendKeys(ConfigReader.getProperty("adress"));
        Driver.getDriver().findElement(By.id("WorkingSector")).sendKeys(ConfigReader.getProperty("work"));
        Driver.getDriver().findElement(By.id("BirthDate")).sendKeys(ConfigReader.getProperty("birth"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    @Test (dependsOnMethods = "test03")
    public void test04() {
        Driver.getDriver().findElement(By.id("btnSubmit")).isDisplayed();
        Driver.getDriver().findElement(By.id("btnSubmit")).click();
    }

    @Test (dependsOnMethods = "test04")
    public void test05() {
        Driver.getDriver().findElement(By.xpath("//div[@class='bootbox-body']")).isDisplayed();
        Driver.getDriver().findElement(By.xpath("//button[@data-bb-handler='ok']")).click();
        Driver.closeDriver();
    }
}
