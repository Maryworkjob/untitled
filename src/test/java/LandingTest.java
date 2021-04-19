

import lombok.Getter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
@Getter
public class LandingTest {

    public static WebDriver driver = SingleDriverr.getDriver();
    public static LandingPage landingPage;
    public static SettingPage settingPage;
    public static Write write;

    @BeforeClass
    public static void setup(){
        landingPage = new LandingPage();
        settingPage = new SettingPage();
        write = new Write();
    }

    @Test
    public void check(){
        landingPage.open();
        landingPage.clickButtonRandomName();
        landingPage.getDropDown().click();
        // landingPage.openDropDown();
        landingPage.chooseRolloverInfo();
        String email = landingPage.getEmail();
        System.out.println(email);
        landingPage.clickSetting();
        settingPage.waitElementClick10min();
        settingPage.saveResult();
        settingPage.closeSetting();
        landingPage.returnMainPage();
        String poleSecretAddress = settingPage.getSecretAddress();
        System.out.println(poleSecretAddress);
        settingPage.waitElementToClicable();
        landingPage.checkCloseWindowSetting();
        String StringWaitNewMassage = landingPage.displayedWaitNewMessage();
        System.out.println(StringWaitNewMassage);
        Assert.assertEquals("В ожидании новых писем...",StringWaitNewMassage);
        landingPage.openWrite();
        write.formaWrite();
        write.fillFieldEmail();
        write.fillFieldText();
        write.fillFieldSecretAddress();
        write.clickButtonSend();
        landingPage.waitIncoming();
        landingPage.openIncoming();
        landingPage.waitOpenNewMessage();
        String poleEmailIncoming = landingPage.compereEmail();
        Assert.assertEquals(poleEmailIncoming,email);
        System.out.println(email + "   " + poleEmailIncoming);
        String checkText = landingPage.Tekstcheck();
        System.out.println(checkText);
        Assert.assertEquals(checkText,"Test");
        System.out.println(checkText+ " " + "Test");
        String actualSecret = landingPage.compereSecretAdres();
        Assert.assertEquals(actualSecret,poleSecretAddress);
        System.out.println(actualSecret + "   " + poleSecretAddress);
        landingPage.replay();






    }

//    @AfterClass
//    public static void clean(){
//        driver.quit();
//    }

}
