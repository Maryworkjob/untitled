

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingleDriverr {
    public static WebDriver driver = null;

    public static WebDriver getDriver(){
        if (driver == null){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Chomedriverfolder\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void open(String url){
        driver.get(url);
    }

    public static void quit(){
        driver.quit();
        driver= null;
    }

}
