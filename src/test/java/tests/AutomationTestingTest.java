package tests;

import bal.*;
import enums.Gender;
import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AutomationTestingTest {
    private static WebDriver _webDriver;
    private static Actions _actions;
    private static Register _register;
    private static WebTable _webTable;
    private static Alert _alert;
    private static Widget _widget;
    private static Interaction _interaction;

    private static final String alertPage = "http://demo.automationtesting.in/Alerts.html";

    @BeforeAll
    public static void SetUp() {
        EnvironmentManager.InitWebDriver("http://demo.automationtesting.in");
        _webDriver = RunEnvironment.GetWebDriver();
        _actions = new Actions(_webDriver);

        _register = new Register(_webDriver);
        _webTable = new WebTable(_webDriver);
        _alert = new Alert(_webDriver);
        _widget = new Widget(_webDriver);
        _interaction = new Interaction(_webDriver, _actions);
    }

    @AfterEach
    public void Wait() {
        RunEnvironment.WaitDriver(2000);
    }

    @AfterAll
    public static void TearUp() {
        RunEnvironment.WaitDriver(10000);
        EnvironmentManager.ShutDownDriver();
    }

    @Test
    @Order(1)
    public void SkipSignIn() {
        Home homePage = new Home(_webDriver);
        homePage.SkipSignIn();
    }

    @Test
    @Order(2)
    public void Register() {
        _register.SetFirstName("John");
        _register.SetLastName("Wick");
        _register.SetAddress("Kathmandu 13, Nepal");
        _register.SetEmailAddress("helloworld@hello.com");
        _register.SetPhoneNumber("9813783883");
    }

    @Test
    @Order(3)
    public void Register_Gender() {
        _register.SelectGender(Gender.Female);
    }

    @Test
    @Order(4)
    public void Register_Hobbies() {
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Movies");
        hobbies.add("Hockey");
        hobbies.add("Cricket");

        _register.SelectHobbies(hobbies);
    }

    @Test
    @Order(5)
    public void Register_Languages() {
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Dutch");
        languages.add("Greek");

        _register.SelectLanguages(languages);
    }

    @Test
    @Order(6)
    public void Register_Skill() {
        _register.SelectSkill("Android");
    }

    @Test
    @Order(7)
    public void Register_Country() {
        _register.SelectCountry("Nepal");
    }

    @Test
    @Order(8)
    public void Regiser_Country_ComboBox() {
        _register.SelectCountryFromComboBox("Netherlands");
    }

    @Test
    @Order(9)
    public void Register_DateOfBirth() {
        _register.SelectYear("1980");
        _register.SelectMonth("April");
        _register.SelectDay("15");
    }

    @Test
    @Order(10)
    public void Register_Password() {
        _register.SetFirstPassword("Nepal123");
        _register.SetSecondPassword("Nepal123");
    }


    @Test
    @Order(11)
    public void Register_UploadPhoto() {
        _register.UploadPhoto("D:\\einstein.jpg");
    }

    @Test
    @Order(12)
    public void Register_Submit() {
        _register.Submit();
        _register.RedirectIfInvalid();
    }

    @Test
    @Order(13)
    public void WebTable_EditDoubleClick() {
        _webTable.DoubleClickEditButton();
    }

    @Test
    @Order(14)
    public void WebTable_EditWebTable() {
        _webTable.EditWebElementRow("ankit@test.com", "ankit", Gender.Male, "pandey", "9813201202");
    }

    @Test
    @Order(15)
    public void WebTable_SaveRow() {
        //has error on app
        _webTable.SaveRow();
    }

    @Test
    @Order(16)
    public void WebTable_CancelRow() {
        _webTable.CancelRow();
    }

    @Test
    @Order(17)
    public void WebTable_SortByFirstName() {
        _webTable.SortByFirstName();
    }

    @Test
    @Order(18)
    public void WebTable_SortByGender() {
        _webTable.SortByGender();
    }

    @Test
    @Order(19)
    public void WebTable_SortByLastName() {
        _webTable.SortByLastName();
    }

    @Test
    @Order(20)
    public void WebTable_SortByPhoneNumber() {
        _webTable.SortByPhoneNumber();
    }

    @Test
    @Order(21)
    public void WebTable_Pagination_TextBox() {
        _webTable.PaginationTextBox();
    }

    @Test
    @Order(22)
    public void Alert_WithOk() {
        _webDriver.get(alertPage);
        _alert.AlertWithOk();
    }

    @Test
    @Order(23)
    public void AlertWithOkAndCancel() {
        if (_webDriver.getCurrentUrl() != alertPage) {
            _webDriver.get(alertPage);
        }
        _alert.AlertWithOkAndCancel();
    }

    @Test
    @Order(24)
    public void AlertWithTextBox() {
        if (_webDriver.getCurrentUrl() != alertPage) {
            _webDriver.get(alertPage);
        }
        _alert.AlertWithTextBox();
    }

    @Test
    @Order(25)
    public void Widget_AutoComplete() {
        if (_webDriver.getCurrentUrl() != "http://demo.automationtesting.in/AutoComplete.html") {
            _webDriver.get("http://demo.automationtesting.in/AutoComplete.html");
        }
        _widget.AutoComplete("Ne");
    }

    @Test
    @Order(26)
    public void Widget_DatePicker() {
        if (!_webDriver.getCurrentUrl().equalsIgnoreCase("http://demo.automationtesting.in/Datepicker.html")) {
            _webDriver.get("http://demo.automationtesting.in/Datepicker.html");
        }
        _widget.DatePickerDisabled("15");
    }

    @Test
    @Order(27)
    public void Widget_Slider() {
        if (!_webDriver.getCurrentUrl().equalsIgnoreCase("http://demo.automationtesting.in/Slider.html")) {
            _webDriver.get("http://demo.automationtesting.in/Slider.html");
        }
        _widget.Slider();
    }

    @Test
    @Order(28)
    public void Interaction_StaticDragAndDrop() {
        if (!_webDriver.getCurrentUrl().equalsIgnoreCase("http://demo.automationtesting.in/Static.html")) {
            _webDriver.get("http://demo.automationtesting.in/Static.html");
        }
        _interaction.StaticDragAndDrop();
    }

    @Test
    @Order(29)
    public void Interaction_SelectableSerialize() {
        if (!_webDriver.getCurrentUrl().equalsIgnoreCase("http://demo.automationtesting.in/Selectable.html")) {
            _webDriver.get("http://demo.automationtesting.in/Selectable.html");
        }
        _interaction.SelectableSerialize();
    }

    @Test
    @Order(30)
    public void Interaction_Resizable() {
        if (!_webDriver.getCurrentUrl().equalsIgnoreCase("http://demo.automationtesting.in/Resizable.html")) {
            _webDriver.get("http://demo.automationtesting.in/Resizable.html");
        }
        _interaction.Resizable();
    }

    @Test
    @Order(31)
    void TakeScreenshot() {
        RunEnvironment.TakeScreenShot(
                "D:\\Susen\\Automated Testing\\Screenshot",
                "ScreenShot1",
                "png");
    }
}
