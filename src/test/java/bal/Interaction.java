package bal;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

public class Interaction {
    private WebDriver _webDriver;
    private Actions _actions;

    public Interaction(WebDriver webDriver, Actions actions) {
        _webDriver = webDriver;
        _actions = actions;
    }

    public void StaticDragAndDrop() {

        WebElement dragged = _webDriver.findElement(By.id("mongo"));
        WebElement dropped = _webDriver.findElement(By.id("droparea"));


        //_actions.clickAndHold(dragged).moveToElement(dropped).release().build().perform();
        //_actions.dragAndDrop(dragged, dropped).build().perform();

        Point pointX = ((Locatable) dragged).getCoordinates().inViewPort();
        int draggedX = pointX.getX();
        int draggedY = pointX.getY();

        Point pointY = ((Locatable)dropped).getCoordinates().inViewPort();
        int droppedX = pointX.getX();
        int droppedY = pointY.getY();

        try {
            new Actions(_webDriver).dragAndDrop(dragged, dropped).release().build().perform();
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
        } catch (AWTException e) {
            e.printStackTrace();
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
