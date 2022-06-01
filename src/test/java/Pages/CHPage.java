package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CHPage {

    public CHPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@class='nav-link'])[1]")
    public WebElement homeButon;

    @FindBy(xpath = "(//a[@class='nav-link'])[2]")
    public WebElement roomsButon;

    @FindBy(xpath = "(//a[@class='nav-link'])[3]")
    public WebElement restaurantButon;

    @FindBy(xpath = "(//a[@class='nav-link'])[4]")
    public WebElement aboutButon;

    @FindBy(xpath = "(//a[@class='nav-link'])[5]")
    public WebElement blogButon;

    @FindBy(xpath = "(//a[@class='nav-link'])[6]")
    public WebElement contactButon;

    @FindBy(xpath = "(//a[@class='nav-link'])[7]")
    public WebElement logInButon;

    public void anasayfa() {
        Driver.getDriver().get("https://qa-environment.concorthotel.com");
        Driver.getDriver().findElement(By.id("details-button")).click();
        Driver.getDriver().findElement(By.id("proceed-link")).click();
    }

    @FindBy(id = "UserName")
    public WebElement userName;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy (id = "btnSubmit")
    public WebElement kullaniciGiris;

    @FindBy (xpath = "//span[@class='btn btn-primary py-3 px-5']")
    public WebElement createAccount;







}

