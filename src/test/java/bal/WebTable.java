package bal;

import enums.Gender;
import environment.RunEnvironment;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebTable {
    private static WebDriver _webDriver;

    public WebTable(WebDriver webDriver) {
        this._webDriver = webDriver;
    }

    public void DoubleClickEditButton() {
        Actions action = new Actions(_webDriver);
        action.moveToElement(_webDriver.findElement(By.cssSelector(".fa-pencil"))).doubleClick().build().perform();
    }

    public void EditWebElementRow(String email, String firstName, Gender gender, String lastName, String phoneNumber) {
        WebElement emailElement = _webDriver.findElement(By.xpath("//input[@value='anki@test.com']"));
        emailElement.clear();
        emailElement.sendKeys(email);

        WebElement firstNameElement = _webDriver.findElement(By.xpath("//input[@value='ankita']"));
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);

        //should have been dropdown
        WebElement genderElement = _webDriver.findElement(By.xpath("//input[@value='FeMale']"));
        genderElement.clear();
        genderElement.sendKeys("Male");

        WebElement lastNameElement = _webDriver.findElement(By.xpath("//input[@value='chaudhari']"));
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);

        WebElement phoneNumberElement = _webDriver.findElement(By.xpath("//input[@value='7894561237']"));
        phoneNumberElement.clear();
        phoneNumberElement.sendKeys(phoneNumber);
    }

    public void SaveRow() {
        WebElement saveBtn = _webDriver.findElement(By.xpath("//button[@type='button']"));
        saveBtn.click();
    }

    public void CancelRow() {
        WebElement cancelBtn = _webDriver.findElement(By.xpath("//cancel-click/button"));
        cancelBtn.click();
    }

    public void SortByFirstName() {
        WebElement sortElement = _webDriver.findElement(By.xpath("//div[@col-index='renderIndex']/span"));
        sortElement.click();
        RunEnvironment.WaitDriver(5000);
        sortElement.click();
    }

    public void SortByGender() {
        WebElement sortElement = _webDriver.findElement(By.xpath("//div[@class='ui-grid-header-cell ui-grid-clearfix ng-scope ng-isolate-scope ui-grid-coluiGrid-0007']/div[@class='ng-scope sortable']"));
        sortElement.click();
    }

    public void SortByLastName() {
        WebElement sortElement = _webDriver.findElement(By.xpath("//div[@class='ui-grid-header-cell ui-grid-clearfix ng-scope ng-isolate-scope ui-grid-coluiGrid-0008']/div[@class='ng-scope sortable']"));
        sortElement.click();
    }

    public void SortByPhoneNumber() {
        WebElement sortElement = _webDriver.findElement(By.xpath("//div[@class='ui-grid-header-cell ui-grid-clearfix ng-scope ng-isolate-scope ui-grid-coluiGrid-0009']/div[@class='ng-scope sortable']"));
        sortElement.click();
    }

    public void PaginationTextBox() {
        WebElement textBox = _webDriver.findElement(By.xpath("//input[@ng-model='grid.options.paginationCurrentPage']"));

        textBox.sendKeys(Keys.chord(Keys.ARROW_UP));
        RunEnvironment.WaitDriver(2000);

        textBox.sendKeys(Keys.chord(Keys.ARROW_UP));
        RunEnvironment.WaitDriver(200);

        textBox.sendKeys(Keys.chord(Keys.ARROW_DOWN));
        RunEnvironment.WaitDriver(2000);

        textBox.sendKeys(Keys.chord(Keys.ARROW_DOWN));
    }
}
