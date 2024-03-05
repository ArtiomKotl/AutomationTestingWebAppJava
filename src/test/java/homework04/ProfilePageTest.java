package homework04;

import com.codeborne.selenide.Selenide;
import org.example.homework03.LoginPage;
import org.example.homework03.ProfilePage;
import org.example.homework03.StudentPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.page;

public class ProfilePageTest extends AbstractTest {
    @Test
    void changeBirthDayInProfileSelenideTest() {
        LoginPage loginPage = page(LoginPage.class);
        loginPage.loginInSystem(USERNAME, PASSWORD);
        Selenide.sleep(5000L);

        StudentPage studentPage = page(StudentPage.class);
        studentPage.openProfile();

        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickEditProfile();
        profilePage.uploadNewBirthDayDate("01.01.2001");
        Selenide.sleep(5000);
        profilePage.clickSaveProfileUpdateData();
        profilePage.clickCloseWidowEditingProfile();

        Assertions.assertEquals("01.01.2001",profilePage.getDayOfBirthText());
        Selenide.sleep(5000L);
    }
}
