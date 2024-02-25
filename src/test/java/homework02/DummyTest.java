package homework02;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.example.homework02.*;

public class DummyTest extends AbstractTest {

    @Test
        // Домашнее задание 2: задача 1
    void loginWithOutAuthorizationTest() {
        driver.get("https://test-stand.gb.ru/login");

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loginWithOutAuthorization();

        WebElement error = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//h2[@class='svelte-uwkxn9']")));
        Assertions.assertEquals("401", error.getText());
    }




}