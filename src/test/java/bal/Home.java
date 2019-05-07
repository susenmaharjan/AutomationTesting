package bal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Home {
    private static WebDriver _webDriver;

    public Home(WebDriver webDriver) {
        this._webDriver = webDriver;
    }

    public void SkipSignIn() {
        this._webDriver.findElement(By.id("btn2")).click();
    }
}
