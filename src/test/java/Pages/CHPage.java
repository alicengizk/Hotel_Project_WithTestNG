package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
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

    public void adminGiris() {
        Driver.getDriver().get("https://qa-environment.concorthotel.com");
        Driver.getDriver().findElement(By.id("details-button")).click();
        Driver.getDriver().findElement(By.id("proceed-link")).click();
        logInButon.click();
        userName.sendKeys(ConfigReader.getProperty("chAdminUser"));
        password.sendKeys(ConfigReader.getProperty("chAdminPassword"));
        kullaniciGiris.click();
    }

    @FindBy(id = "UserName")
    public WebElement userName;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(id = "btnSubmit")
    public WebElement kullaniciGiris;

    @FindBy(xpath = "//span[@class='btn btn-primary py-3 px-5']")
    public WebElement createAccount;

    @FindBy(id = "menuHotels")
    public WebElement hotelManage;

    @FindBy(xpath = "//a[@href='/admin/HotelAdmin']")
    public WebElement hotelList;

    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addHotel;

    @FindBy(id = "Code")
    public WebElement hotelCode;

    @FindBy(id = "btnSubmit")
    public WebElement saveButon;

    @FindBy(xpath = "//select[@id='IDGroup']//option[@value='1']")
    public WebElement hotelType;

    @FindBy(xpath = "//a[@href='/admin/HotelRoomAdmin']")
    public WebElement hotelRooms;

    @FindBy(xpath = "(//i[@class='fa fa-search'])[2]")
    public WebElement roomDetail;

    @FindBy (xpath = "//a[@href='/admin/RoomReservationAdmin']")
    public WebElement roomReservations;

    @FindBy (xpath = "//span[@class='hidden-480']")
    public WebElement addReservation;


}

