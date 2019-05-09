package environment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnvironmentManager {
    public static void InitWebDriver(String url){
        System.setProperty("webdriver.chrome.driver", "D:\\Susen\\Selenium drivers\\chromedriver.exe");
        WebDriver _webDriver = new ChromeDriver();
        _webDriver.manage().window().maximize();
        _webDriver.get(url);
        RunEnvironment.SetWebDriver(_webDriver);
    }

    public static void ShutDownDriver(){
        RunEnvironment.GetWebDriver().close();
        RunEnvironment.GetWebDriver().quit();
    }

}
