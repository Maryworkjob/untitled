

import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter
public class LandingPage extends SingleDriverr {


    // public WebDriver driver;

    @FindBy(css = "#pre_rand > span:nth-child(2)")
    private WebElement buttonRandomName;

    @FindBy(css = "#domain")
    private WebElement dropDown;

    @FindBy(css = "#pre_form > div > div.dropdown.mb-30.mb-md-0 > div > button:nth-child(6)")
    private WebElement rolloverInfo;

    @FindBy(css = "#pre_button")
    private WebElement email;

    @FindBy(css = "#pre_settings")
    private WebElement settingButton;

    @FindBy(css = "#pre_settings")
    private WebElement WaitSettingButton;

    @FindBy(css = "#pre_settings")
    private WebElement CloseWindowSetting;

    @FindBy(css = "#container-body > div > div.inbox > div > span")
    private WebElement StringWaitNewMessage;

    @FindBy(css = "#compose")
    private WebElement buttonWrite;

    @FindBy(css = "#container-body > div > div.inbox > div.mail > div")
    private WebElement formIncoming ;

    @FindBy(css = "#container-body > div > div.inbox > div.mail > div")
    private WebElement newMessage;//click

    @FindBy(css = "#info > div.row.row-info.no-gutters > div.col.d-flex.mb-10 > span")
    private WebElement poleEmailIncoming;

    @FindBy(css = "#info > div.subject.mb-20")
    private WebElement poleTextIncoming;

    @FindBy(css = "#info > div.overflow-auto.mb-20")
    private WebElement poleSecretAdressIncoming;

    @FindBy(xpath = "//*[@id=\"back\"]")
    private WebElement buttonBack;

    @FindBy(xpath = "//*[@id=\"reply\"]")
    private  WebElement buttonReplay;




    public LandingPage() {
        PageFactory.initElements(getDriver(), this);
        // this.driver=driver;
    }

    public void open() {
        open("https://tempmail.plus/ru/");
    }

    public void clickButtonRandomName() {
        buttonRandomName.click();
    }
    public void DropDown() {
        dropDown.click();
    }
    public void chooseRolloverInfo() {
        rolloverInfo.click();
    }
    public String getEmail() { return email.getAttribute("value") + "@rover.info"; }
    public void clickSetting() {
        settingButton.click();
    }// нажали на настройки перехожу на страницу setting Page
    public void returnMainPage() { new WebDriverWait(getDriver(), 60).until(ExpectedConditions.visibilityOf(WaitSettingButton)).click(); } // ожидаю кнопку настройки и нажимаю по ней снова и перехожу на лэйтинг пэдж
    public void checkCloseWindowSetting() { CloseWindowSetting.isDisplayed(); } //проверить что окно закрывается /ПЕРЕДЕЛАТЬ под ASSERT.ASSERT TRUE
    public String displayedWaitNewMessage() { return StringWaitNewMessage.getAttribute("textContent");} // сравниваем текст в ожидании новых писем
    public void openWrite(){ buttonWrite.click();} // нажимаем на кнопку написать
    public void waitIncoming (){new WebDriverWait(getDriver(),100).until((ExpectedConditions.visibilityOf(formIncoming)));} // ожидаем новое Входящее письмо
    public void openIncoming(){newMessage.click();}
    public void waitOpenNewMessage() { new WebDriverWait(getDriver(), 60).until(ExpectedConditions.visibilityOf(poleEmailIncoming)).click(); } //ожидаем открытие письма по полю мыло
    public String compereEmail (){return poleEmailIncoming.getAttribute("textContent");} // сравнить мьыло во входящем письме
    public String Tekstcheck(){return poleTextIncoming.getAttribute("textContent");}
    public String compereSecretAdres(){return poleSecretAdressIncoming.getAttribute("textContent");}
    public void replay(){buttonReplay.click();}

    }





