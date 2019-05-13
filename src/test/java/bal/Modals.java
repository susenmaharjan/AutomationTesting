package bal;

import environment.RunEnvironment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Modals {
    private WebDriver _webDriver;

    public Modals(WebDriver webDriver) {
        _webDriver = webDriver;
    }

    public void LaunchBootstrapModal(){
        _webDriver.findElement(By.xpath("//a[@href='#myModal']")).click();
        RunEnvironment.WaitDriver(3000);
        _webDriver.findElement(By.xpath("//button[contains(.,'Close')]")).click();
    }

    public void LaunchMultiBootstrapModals() {
        _webDriver.findElement(By.xpath("//a[@href='#myModalMulti']")).click();
        RunEnvironment.WaitDriver(3000);
        _webDriver.findElement(By.xpath("//a[@href='#myModal2']")).click();
        RunEnvironment.WaitDriver(3000);
        _webDriver.findElement(By.xpath("//div[@id='myModal2']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-footer']/a[@class='btn btn-primary']")).click();
    }
}
