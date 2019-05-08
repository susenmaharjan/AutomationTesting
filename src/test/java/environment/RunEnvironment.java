package environment;

import org.openqa.selenium.WebDriver;

public class RunEnvironment {
    public static WebDriver _webDriver;

    public static WebDriver GetWebDriver() {
        return _webDriver;
    }

    public static void SetWebDriver(WebDriver webDriver) {
        RunEnvironment._webDriver = webDriver;
    }

    public static void WaitDriver(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
