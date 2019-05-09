package tests;

import bal.Home;
import bal.Register;
import bal.WebTable;
import enums.Gender;
import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AutomationTestingTest {
    private static WebDriver _webDriver;
    private static Register _register;
    private static WebTable _webTable;

    @BeforeAll
    public static void SetUp() {
        EnvironmentManager.InitWebDriver("http://demo.automationtesting.in");
        _webDriver = RunEnvironment.GetWebDriver();
        _register = new Register(_webDriver);
        _webTable = new WebTable(_webDriver);
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
    public void WebTable_SortByLastName(){
        _webTable.SortByLastName();
    }

    @Test
    @Order(20)
    public void WebTable_SortByPhoneNumber(){
        _webTable.SortByPhoneNumber();
    }

    @Test
    @Order(21)
    public void WebTable_Pagination_TextBox(){
        _webTable.PaginationTextBox();
    }

}
