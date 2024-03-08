package homework04;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.Map;


public class AbstractTest {





     protected static String USERNAME;
    protected static String PASSWORD;

    @BeforeAll
    public static void setUpTest(){
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "121.0";
        Map<String, Object> options = new HashMap<>();
        options.put("enableVNC", true);
        options.put("enableLog", true);
        Configuration.browserCapabilities.setCapability("selenoid:options", options);
        Selenide.open("https://test-stand.gb.ru/login");


    }
    @BeforeEach
    public void init() {

        USERNAME = System.getProperty("geekbrains_username", System.getenv("geekbrains_username"));
        PASSWORD = System.getProperty("geekbrains_password", System.getenv("geekbrains_password"));
    }




    @AfterAll
    static void close() {
        WebDriverRunner.closeWebDriver();
    }

}
