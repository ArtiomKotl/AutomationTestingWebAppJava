package homework04;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import org.example.homework03.DummyCredentialsPage;
import org.example.homework03.LoginPage;
import org.example.homework03.StudentPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CredentialsTest extends AbstractTest {

    @Test
        // Домашнее задание 2: задача 3
    void credentialsWindowTest()  {
        LoginPage loginPage = Selenide.page(LoginPage.class);
        loginPage.loginInSystem(USERNAME, PASSWORD);

        SelenideElement search = $x("//a[@href='/about']").shouldBe(visible);
        Assertions.assertEquals("About", search.text());

        StudentPage studentPage = Selenide.page(StudentPage.class);
        studentPage.checkStudent("24875");
        Selenide.sleep(5000);

        DummyCredentialsPage dummyCredentialsPage = Selenide.page(DummyCredentialsPage.class);

        Assertions.assertAll(() -> Assertions.assertEquals("Dummy credentials", dummyCredentialsPage
                        .findTitle().getText()),
                () -> Assertions.assertTrue((dummyCredentialsPage.findLoginAndPW().text().contains("Login"))),
                () -> Assertions.assertTrue((dummyCredentialsPage.findLoginAndPW().text().contains("PW"))),
                () -> Assertions.assertEquals("CLOSE", dummyCredentialsPage.findCloseButton().text()));

        Selenide.sleep(5000);
    }
}
