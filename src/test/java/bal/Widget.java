package bal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Widget {
    private WebDriver _webDriver;

    public Widget(WebDriver webDriver) {
        _webDriver = webDriver;
    }

    public void AutoComplete(String countryName) {
        WebElement searchBox = _webDriver.findElement(By.id("searchbox"));
        searchBox.sendKeys(countryName);

        //WebElement country = _webDriver.findElement(By.xpath("//li[@class='ui-menu-item']/a[@textContent=Nepal]"));
        List<WebElement> autoSuggest = _webDriver.findElements(By.className("ui-menu-item"));

        System.out.println("Total size: " + autoSuggest.size());
        for (WebElement country : autoSuggest) {
            System.out.println("Values are " + country.getText());
        }
    }

    public void DatePickerDisabled(String date) {
        _webDriver.findElement(By.id("datepicker1")).click();
        WebElement dateWidget = _webDriver.findElement(By.xpath("//div[@id='ui-datepicker-div']/table[@class='ui-datepicker-calendar']/tbody"));

        List<WebElement> columns = dateWidget.findElements(By.tagName("td"));

        System.out.println("Size = " + columns.size());

        for (WebElement cell : columns) {
            if(cell.getText().equals(date)){
                cell.click();
                break;
            }
        }
    }
}
