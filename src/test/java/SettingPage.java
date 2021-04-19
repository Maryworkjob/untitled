

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingPage extends SingleDriverr {

    @FindBy(css = "#modal-settings > div > form > div.modal-body > div:nth-child(1) > div.btn-group.btn-group-toggle.d-flex > label:nth-child(1)")
    private WebElement webElementSettings;

    @FindBy(css = "#modal-settings > div > form > div.modal-body > div:nth-child(2) > input")
    private WebElement saveResult;

    @FindBy(css = "#modal-settings > div > form > div.modal-header > div > button")
    private WebElement clickSettingClose;

    @FindBy(css = "#secret-address")
    private WebElement poleSecretAddress;

    @FindBy(css = "#modal-settings > div > form > div.modal-header > div > button")
    private WebElement elementClicable;

    @FindBy(css = "#modal-settings > div > form > div.modal-header > div > button")
    private WebElement clickSettingClose2;


    //public WebDriver driver;

    public SettingPage(){
        PageFactory.initElements(SingleDriverr.getDriver(),this);
       // this.driver=driver;
    }
    public void waitElementClick10min(){ new WebDriverWait(getDriver(),60).until(ExpectedConditions.visibilityOf(webElementSettings)).click(); }// жду 10 мин и кликаю на них
    public void saveResult(){ saveResult.click(); } // нажимаю сохранить результат
    public void closeSetting(){ clickSettingClose.click();} // закрываю форму перехожу на стр лентинг пэйдж
    public String getSecretAddress(){ return poleSecretAddress.getAttribute("textContent"); } //копирую секретный адресс
    public void waitElementToClicable(){ new WebDriverWait(getDriver(),60).until(ExpectedConditions.elementToBeClickable(elementClicable)).click();// ждем когда элемент будет кликабельный и закрываем окно настройки

}
}
