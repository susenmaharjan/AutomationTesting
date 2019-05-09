package bal;

import environment.RunEnvironment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Alert {
    private WebDriver _webDriver;

    public Alert(WebDriver webDriver) {
        _webDriver = webDriver;
    }

    private  void WaitForTwoSeconds(){
        RunEnvironment.WaitDriver(2000);
    }

    public void AlertWithOk() {
        _webDriver.findElement(By.xpath("//div[@id='OKTab']/button")).click();
        WaitForTwoSeconds();
        _webDriver.switchTo().alert().accept();
    }

    public void AlertWithOkAndCancel() {
        _webDriver.findElement(By.xpath("//a[@href='#CancelTab']")).click();
        WaitForTwoSeconds();

        _webDriver.findElement(By.xpath("//div[@id='CancelTab']/button")).click();
        WaitForTwoSeconds();

        _webDriver.switchTo().alert().dismiss();
    }

    public void AlertWithTextBox() {
        _webDriver.findElement(By.xpath("//a[@href='#Textbox']")).click();
        WaitForTwoSeconds();

        _webDriver.findElement(By.xpath("//div[@id='Textbox']/button")).click();

        WaitForTwoSeconds();

        _webDriver.switchTo().alert().sendKeys("John Wick");

        WaitForTwoSeconds();

        _webDriver.switchTo().alert().accept();
    }
}
