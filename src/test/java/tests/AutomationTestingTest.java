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

    @BeforeAll
    public static void SetUp(){
        EnvironmentManager.InitWebDriver("http://demo.automationtesting.in");
        _webDriver = RunEnvironment.GetWebDriver();
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
        Register register = new Register(_webDriver);

        register.SetFirstName("John");
        register.SetLastName("Wick");
        register.SetAddress("Kathmandu 13, Nepal");
        register.SetPhoneNumber("9813783883");
        register.SetEmailAddress("helloworld@hello.com");
        register.SelectGender(Gender.Female);

        List<String> hobbies = new ArrayList<>();
        hobbies.add("Movies");
        hobbies.add("Hockey");
        hobbies.add("Cricket");

        register.SelectHobbies(hobbies);


        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Dutch");
        languages.add("Greek");

        register.SelectLanguages(languages);

    }
}
