package homework02;

import org.example.homework02.DummyCredentialsPage;
import org.example.homework02.LoginPage;
import org.example.homework02.StudentPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CredentialsTest extends AbstractTest{

    @Test
        // Домашнее задание 2: задача 3
    void credentialsWindowTest() throws InterruptedException {
        driver.get("https://test-stand.gb.ru/login");

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loginInSystem(USERNAME, PASSWORD);

        WebElement search = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//a[@href='/about']")));
        Assertions.assertEquals("About", search.getText());

        StudentPage studentPage = new StudentPage(driver, wait);
        studentPage.checkStudent("24875");

        // Вариант проверки - 1
        WebElement checkTitle = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(" //h2[@id='simple-title']")));
        WebElement checkLoginAndPW = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(" //div[@id='simple-content']")));
        WebElement checkCloseButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(" //div[@class='mdc-dialog__actions']/button/span")));

        Assertions.assertAll(() -> Assertions.assertEquals("Dummy credentials", checkTitle.getText()),
                () -> Assertions.assertTrue(checkLoginAndPW.getText().contains("Login")),
                () -> Assertions.assertTrue(checkLoginAndPW.getText().contains("PW")),
                () -> Assertions.assertEquals("CLOSE", checkCloseButton.getText()));

        // Вариант проверки - 2

        DummyCredentialsPage dummyCredentialsPage = new DummyCredentialsPage(driver, wait);
        Assertions.assertEquals("Dummy credentials", dummyCredentialsPage.findTitle().getText());
        Assertions.assertTrue((dummyCredentialsPage.findLoginAndPW().getText().contains("Login")));
        Assertions.assertTrue((dummyCredentialsPage.findLoginAndPW().getText().contains("PW")));
        Assertions.assertEquals("CLOSE", dummyCredentialsPage.findCloseButton().getText());

    }
}
