package homework02;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.example.homework02.*;

import java.util.List;

public class LoginPageTest extends AbstractTest {

    @Test
    void loginTest() throws InterruptedException {
        driver.get("https://test-stand.gb.ru/login");

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loginInSystem(USERNAME, PASSWORD);

        Thread.sleep(2000L);
        List<WebElement> searchList = driver.findElements(By.partialLinkText("Hello"));
        Assertions.assertEquals(1, searchList.size());

        MainPage mainPage = new MainPage(driver, wait);
        mainPage.createPost();

        List<WebElement> title = driver.findElements(By.xpath("//*[@type='text']"));
        Assertions.assertEquals(1, title.size());

        CreatePostPage createPostPage = new CreatePostPage(driver);
        createPostPage.savePost("11111111", "22222222");

        Thread.sleep(2000L);
        ElementPage elementPage = new ElementPage(driver);
        elementPage.deletePost();

    }

}
