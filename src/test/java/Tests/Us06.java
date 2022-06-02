package Tests;

import Pages.CHPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;

public class Us06 {
    CHPage chPage=new CHPage();
    Actions actions=new Actions(Driver.getDriver());

    @Test
    public void test01() {
        chPage.anasayfa();
    }
}
