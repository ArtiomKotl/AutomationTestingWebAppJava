package homework02;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractTest {
    static WebDriver driver;
    static WebDriverWait wait;
     protected static String USERNAME;
    protected static String PASSWORD;
    @BeforeAll
    public static void init() {

        USERNAME = System.getProperty("geekbrains_username", System.getenv("geekbrains_username"));
        PASSWORD = System.getProperty("geekbrains_password", System.getenv("geekbrains_password"));

    }
    @BeforeEach
    public void setUpTest()  {
        // Настройки локального WebDriver.a
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized"); // режим полного экрана
        chromeOptions.addArguments("incognito");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }


    @AfterAll
    static void close() throws InterruptedException {
        Thread.sleep(3000L);
        driver.quit();
    }

}
