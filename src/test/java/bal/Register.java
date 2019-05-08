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
        List<WebElement> selectedLanguages = languageList.stream()
                .filter(x -> languages.contains(x.getText())).collect(Collectors.toList());

        for (WebElement language : selectedLanguages) {
            language.click();
        }
        languageDropdown.click();
    }

    public void SelectSkill(String selectedSkill) {
        WebElement skillsElement = _webDriver.findElement(By.id("Skills"));

        WebElement skill = skillsElement.findElements(By.tagName("option"))
                .stream()
                .filter(x -> x.getAttribute("value").equals(selectedSkill))
                .collect(Collectors.toList()).get(0);


        skill.click();
    }

    public void SelectCountry(String selectedCountry) {
        Select countriesList = new Select(_webDriver.findElement(By.id("countries")));
        countriesList.selectByValue(selectedCountry);
    }

    public void SelectCountryFromComboBox(String selectedCountry) {
        _webDriver.findElement(By.className("select2-selection--single")).click();

        WebElement textBox = _webDriver.findElement(By.className("select2-search__field"));
        textBox.sendKeys(selectedCountry);

        WebElement countriesElement = _webDriver.findElement(By.className("select2-results__options"));

        WebElement country = countriesElement.findElements(By.tagName("li"))
                .stream()
                .filter(x -> x.getText().equals(selectedCountry))
                .collect(Collectors.toList()).get(0);
        country.click();
    }

    public void SelectYear(String selectedYear) {
        Select yearList = new Select(_webDriver.findElement(By.id("yearbox")));
        yearList.selectByValue(selectedYear);
    }

    public void SelectMonth(String selectedMonth) {

        Select monthList = new Select(_webDriver.findElement(By.xpath("//select[@ng-model='monthbox']")));

        monthList.selectByValue(selectedMonth);
    }

    public void SelectDay(String selectedDay) {
        Select dayList = new Select(_webDriver.findElement(By.id("daybox")));
        dayList.selectByValue(selectedDay);
    }

    public void SetFirstPassword(String password) {
        WebElement passwordElement = _webDriver.findElement(By.id("firstpassword"));
        passwordElement.sendKeys(password);
    }

    public void SetSecondPassword(String password) {
        WebElement passwordElement = _webDriver.findElement(By.id("secondpassword"));
        passwordElement.sendKeys(password);
    }

    public void UploadPhoto(String path) {
        WebElement uploadPhotoElement = _webDriver.findElement(By.id("imagesrc"));
        uploadPhotoElement.sendKeys(path);
    }

    public void Submit() {
        _webDriver.findElement(By.id("submitbtn")).click();
    }

    public void RedirectIfInvalid() {
        String url = _webDriver.getCurrentUrl();
        if(!url.equals("http://demo.automationtesting.in/WebTable.html")){
            _webDriver.get("http://demo.automationtesting.in/WebTable.html");
        }
    }
}
