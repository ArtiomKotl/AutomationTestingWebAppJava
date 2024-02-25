package homework02;

import org.apache.commons.lang3.RandomStringUtils;
import org.example.homework02.EditingDummyPage;
import org.example.homework02.LoginPage;
import org.example.homework02.StudentPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChangeNameTest extends AbstractTest{

    @Test
        // Домашнее задание 2: задача 2
    void dummyChangeNameTest() throws InterruptedException {
        driver.get("https://test-stand.gb.ru/login");

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loginInSystem(USERNAME, PASSWORD);

        WebElement search = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//a[@href='/about']")));
        Assertions.assertEquals("About", search.getText());

        StudentPage studentPage = new StudentPage(driver, wait);
        studentPage.editStudent("24875");

        WebElement searchId = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(" //span[@slot='title']")));
        Assertions.assertEquals("Editing Dummy 24875", searchId.getText());

        String a = RandomStringUtils.randomAlphabetic(3);
        String b = RandomStringUtils.randomAlphanumeric(3);
        String newName = a + b;

        EditingDummyPage editingDummyPage = new EditingDummyPage(driver, wait);
        editingDummyPage.ChangeDummyFirstName(newName);

        String checkName = studentPage.getStudentNameByid("24875");
        Assertions.assertNotEquals(newName, checkName);
    }
}
