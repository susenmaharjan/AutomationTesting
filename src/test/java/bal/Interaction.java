package bal;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Interaction {
    private WebDriver _webDriver;
    private Actions _actions;

    public Interaction(WebDriver webDriver, Actions actions) {
        _webDriver = webDriver;
        _actions = actions;
    }

    public void StaticDragAndDrop() {
        JavascriptExecutor jsDriver = (JavascriptExecutor)_webDriver;
        {
            WebElement dragged = _webDriver.findElement(By.id("angular"));
            WebElement dropped = _webDriver.findElement(By.id("droparea"));
            Actions builder = new Actions(_webDriver);
            builder.dragAndDrop(dragged, dropped).perform();
        }
    }

    public void SelectableSerialize() {
        _webDriver.findElement(By.xpath("//a[@href='#Serialize']")).click();

        List<WebElement> elements = _webDriver.findElements(By.xpath("//ul[@class='SerializeFunc']/li"));

        for (WebElement element : elements) {
            _actions.keyDown(Keys.CONTROL).build().perform();
            element.click();
            _actions.keyUp(Keys.CONTROL).build().perform();
        }

    }

    public void Resizable() {
        WebElement resizable = _webDriver.findElement(By.className("ui-icon-gripsmall-diagonal-se"));
        _actions.clickAndHold(resizable).moveByOffset(150, 200).release().build().perform();
    }

}
