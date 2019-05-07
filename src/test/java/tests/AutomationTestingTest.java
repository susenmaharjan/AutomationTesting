package tests;

import bal.Home;
import bal.Register;
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
    private  static Register _register;

    @BeforeAll
    public static void SetUp(){
        EnvironmentManager.InitWebDriver("http://demo.automationtesting.in");
        _webDriver = RunEnvironment.GetWebDriver();
        _register = new Register(_webDriver);
    }

    @AfterEach
    public void Wait(){
        RunEnvironment.WaitDriver();
    }

    @AfterAll
    public static void TearUp(){
        EnvironmentManager.ShutDownDriver();
    }

    @Test
    @Order(1)
    public void SkipSignIn(){
        Home homePage = new Home(_webDriver);
        homePage.SkipSignIn();
    }

    @Test
    @Order(2)
    public void Register(){
        _register.SetFirstName("John");
        _register.SetLastName("Wick");
        _register.SetAddress("Kathmandu 13, Nepal");
        _register.SetPhoneNumber("9813783883");
        _register.SetEmailAddress("helloworld@hello.com");
    }

    @Test
    @Order(3)
    public void Register_Gender(){
        _register.SelectGender(Gender.Female);
    }

    @Test
    @Order(4)
    public void Register_Hobbies(){
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Movies");
        hobbies.add("Hockey");
        hobbies.add("Cricket");

        _register.SelectHobbies(hobbies);
    }

    @Test
    @Order(5)
    public void Register_Languages(){
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Dutch");
        languages.add("Greek");

        _register.SelectLanguages(languages);
    }

    @Test
    @Order(6)
    public void Register_Skill(){
        _register.SelectSkill("Android");
    }

    @Test
    @Order(7)
    public void Register_Country(){
        _register.SelectCountry("Nepal");
    }
}
