import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Write extends SingleDriverr {
    @FindBy(xpath  = "//*[@id=\"submit\"]")
    private WebElement waitWrait;

    @FindBy(xpath = "//*[@id=\"to\"]")
    private WebElement poleEmail;

    @FindBy(css = "#submit")
    private WebElement buttonSend;

    @FindBy(css = "#subject")
    private WebElement poleText;

    @FindBy(css = "#text")
    private WebElement poleeSecretAddress;


    public Write(){
        PageFactory.initElements(SingleDriverr.getDriver(),this);
        // this.driver=driver;
    }

    public void formaWrite(){new WebDriverWait(getDriver(),30).until(ExpectedConditions.visibilityOf(waitWrait));}
    public void fillFieldEmail(){ poleEmail.sendKeys(LandingTest.landingPage.getEmail()); }
    public void fillFieldText() {poleText.sendKeys("Test") ;}
    public void fillFieldSecretAddress(){poleeSecretAddress.sendKeys(LandingTest.settingPage.getSecretAddress());}
    public void clickButtonSend(){buttonSend.click();}



}
