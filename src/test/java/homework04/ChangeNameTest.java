package homework04;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.homework03.EditingDummyPage;
import org.example.homework03.LoginPage;
import org.example.homework03.StudentPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ChangeNameTest extends AbstractTest {

    @Test

    void dummyChangeNameTest() {
        LoginPage loginPage = Selenide.page(LoginPage.class);
        loginPage.loginInSystem(USERNAME, PASSWORD);

        SelenideElement search = $x("//a[@href='/about']").shouldBe(visible);
        Assertions.assertEquals("About", search.text());
        Selenide.sleep(5000);

        StudentPage studentPage = Selenide.page(StudentPage.class);
        studentPage.editStudent("24875");

        SelenideElement searchId = $x(" //span[@slot='title']").shouldBe(visible,
                Duration.ofMillis(3000L));
        Assertions.assertEquals("Editing Dummy 24875", searchId.text());

        String a = RandomStringUtils.randomAlphabetic(3);
        String b = RandomStringUtils.randomAlphanumeric(3);
        String newName = a + b;

        EditingDummyPage editingDummyPage = Selenide.page(EditingDummyPage.class);
        editingDummyPage.ChangeDummyFirstName(newName);
        Selenide.sleep(5000);

        String checkName = studentPage.getStudentNameById("24875");
        Assertions.assertNotEquals(newName, checkName);

        Selenide.sleep(5000);
    }
}
