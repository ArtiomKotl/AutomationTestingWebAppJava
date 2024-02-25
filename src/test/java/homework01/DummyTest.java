package homework01;


import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private static String USERNAME;
    private static String PASSWORD;



    @BeforeAll
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        USERNAME = System.getProperty("geekbrains_username", System.getenv("geekbrains_username"));
        PASSWORD = System.getProperty("geekbrains_password", System.getenv("geekbrains_password"));
    }

    @BeforeEach
    public void setUpTest() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();


    }
    @Test
    public void createDummyAfterAuthorization() throws IOException {
        driver.get("https://test-stand.gb.ru/login");
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("form#login input[type='text']"))).sendKeys(USERNAME);
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("form#login input[type='password']"))).sendKeys(PASSWORD);
        WebElement loginButton = driver.findElement(By.cssSelector("form#login button"));
        loginButton.click();
        wait.until(ExpectedConditions.invisibilityOf(loginButton));


        WebElement usernameLink = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(USERNAME)));
        assertEquals(String.format("Hello, %s", USERNAME), usernameLink.getText().replace("\n", " ").trim());


        WebElement buttonCreate = wait.until(
                webDriver -> webDriver.findElement(By.id("create-btn")));
        buttonCreate.click();



        WebElement fieldTitle = wait.until(
                webDriver -> webDriver.findElement(By.xpath("//input[@type='text']")));
        fieldTitle.sendKeys("TestSelenium");
        WebElement fieldDescription = wait.until(
                webDriver -> webDriver.findElement(By.xpath("//textarea[@class='mdc-text-field__input']")));
        fieldDescription.sendKeys("Home Work 1");
        WebElement buttonSave = driver.findElement(By.xpath("//button[@type='submit']"));
        buttonSave.click();

        WebElement headingPost = wait.until(
                webDriver -> webDriver.findElement(By.cssSelector("h1[class='svelte-tv8alb']")));



        Assertions.assertEquals("TestSelenium", headingPost.getText());

        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("src/test/resources/screenshotPost.png"));


    }


//    @Test
//    void createDummyAfterAuthorization() {
//        WebElement fieldLogin = driver.findElement(By.xpath("//input[@type='text']"));
//        fieldLogin.sendKeys(myLogin);
//        WebElement fieldPassword = driver.findElement(By.cssSelector("input[type='password']"));
//        fieldPassword.sendKeys(myPassword);
//        WebElement buttonLogin = driver.findElement(By.className("mdc-button__label"));
//        buttonLogin.click();
//
//        WebElement buttonCreate = wait.until(
//                webDriver -> webDriver.findElement(By.id("create-btn")));
//        buttonCreate.click();
//
//        WebElement fieldTitle = wait.until(
//                webDriver -> webDriver.findElement(By.xpath("//input[@type='text']")));
//        fieldTitle.sendKeys("TestSelenium");
//        WebElement fieldDescription = driver.findElement
//                (By.xpath("//textarea[@class='mdc-text-field__input' and @maxlength='100']"));
//        fieldDescription.sendKeys("Home Work 1");
//        WebElement buttonSave = driver.findElement(By.xpath("//button[@type='submit']"));
//        buttonSave.click();
//
//        WebElement headingPost = wait.until(
//                webDriver -> webDriver.findElement(By.cssSelector("h1[class='svelte-tv8alb']")));
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(screenshot, new File("src/test/resources/screenshotPost.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Assertions.assertEquals("TestSelenium", headingPost.getText());
//
//    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
