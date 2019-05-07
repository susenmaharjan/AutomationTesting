package bal;

import enums.Gender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class Register {
    private static WebDriver _webDriver;

    public Register(WebDriver webDriver) {
        this._webDriver = webDriver;
    }

    public void SetFirstName(String firstName) {
        this._webDriver.findElement(By.xpath("//input[@ng-model='FirstName']")).sendKeys(firstName);

    }

    public void SetLastName(String lastName) {
        this._webDriver.findElement(By.xpath("//input[@ng-model='LastName']")).sendKeys(lastName);
    }

    public void SetAddress(String address) {
        this._webDriver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys(address);
    }

    public void SetEmailAddress(String email) {
        this._webDriver.findElement(By.xpath("//input[@ng-model='EmailAdress']")).sendKeys(email);
    }

    public void SetPhoneNumber(String phoneNumber) {
        this._webDriver.findElement(By.xpath("//input[@ng-model='Phone']")).sendKeys(phoneNumber);
    }

    public void SelectGender(Gender gender) {

        List<WebElement> radioOptions = this._webDriver.findElements(By.name("radiooptions"));
        if (gender.equals(Gender.Male)) {
            radioOptions.get(0).click();
        } else {
            radioOptions.get(1).click();
        }
    }

    public void SelectHobbies(List<String> hobbies) {
        for (String hobbie : hobbies) {
            if (hobbie.equalsIgnoreCase("Cricket")) {
                this._webDriver.findElement(By.id("checkbox1")).click();
            } else if (hobbie.equalsIgnoreCase("Movies")) {
                this._webDriver.findElement(By.id("checkbox2")).click();
            } else if (hobbie.equalsIgnoreCase("Hockey")) {
                this._webDriver.findElement(By.id("checkbox3")).click();
            }
        }
    }

    public void SelectLanguages(List<String> languages) {
        WebElement languageDropdown = _webDriver.findElement(By.className("ui-autocomplete-multiselect"));
        languageDropdown.click();

        List<WebElement> languageList = _webDriver.findElements(By.className("ui-corner-all"));
        List<WebElement> test = languageList.stream().filter(languages::contains).collect(Collectors.toList());

        for (WebElement language : test) {
            System.out.println(language.getText());
        }

    }
}
