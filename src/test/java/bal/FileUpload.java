package bal;

import environment.RunEnvironment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUpload {
    private WebDriver _webDriver;

    public FileUpload(WebDriver webDriver) {
        _webDriver = webDriver;
    }

    public void UploadFile(String filePath){
        WebElement browseBtn = _webDriver.findElement(By.id("input-4"));
        browseBtn.sendKeys(filePath);

        RunEnvironment.WaitDriver(3000);

        WebElement removeBtn = _webDriver.findElement(By.xpath("//button[@title='Clear selected files']"));
        removeBtn.click();

        RunEnvironment.WaitDriver(3000);
        browseBtn.sendKeys(filePath);

        RunEnvironment.WaitDriver(3000);

        //zoom in
        WebElement zoomBtn = _webDriver.findElement(By.xpath("//button[@title='View Details']"));
        zoomBtn.click();

        RunEnvironment.WaitDriver(3000);

        //toggle header
        WebElement toggleHeaderBtn = _webDriver.findElement(By.xpath("//button[@title='Toggle header']"));
        toggleHeaderBtn.click();

        RunEnvironment.WaitDriver(3000);

        //toggle full screen
        WebElement toggleFullscreenBtn = _webDriver.findElement(By.xpath("//button[@title='Toggle borderless mode']"));
        toggleFullscreenBtn.click();

        RunEnvironment.WaitDriver(3000);

        //Toggle borderless mode
        WebElement toggleBorderlessBtn = _webDriver.findElement(By.xpath("//button[@title='Toggle borderless mode']"));
        toggleBorderlessBtn.click();

        RunEnvironment.WaitDriver(3000);
        //close modal
        _webDriver.findElement(By.xpath("//button[@title='Close detailed preview']")).click();

        RunEnvironment.WaitDriver(3000);

        //upload
        WebElement uploadBtn = _webDriver.findElement(By.xpath("//button[@type='submit']"));
        uploadBtn.click();
    }
}
