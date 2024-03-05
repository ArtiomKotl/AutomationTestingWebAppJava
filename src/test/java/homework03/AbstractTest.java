package homework03;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


public class AbstractTest {

     protected static String USERNAME;
    protected static String PASSWORD;
    @BeforeAll
    public static void init() {

        USERNAME = System.getProperty("geekbrains_username", System.getenv("geekbrains_username"));
        PASSWORD = System.getProperty("geekbrains_password", System.getenv("geekbrains_password"));

    }
    @BeforeEach
    public void setUpTest()  {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        Selenide.open("https://test-stand.gb.ru/login");

    }


    @AfterAll
    static void close() {
        WebDriverRunner.closeWebDriver();
    }

}
