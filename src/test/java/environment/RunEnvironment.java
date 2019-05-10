package environment;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

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

    public static void TakeScreenShot(String outputFilePath, String fileName, String fileFormat) {
        File srcFile = ((TakesScreenshot) _webDriver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(srcFile, new File(outputFilePath + "//" + fileName + "." + fileFormat));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
