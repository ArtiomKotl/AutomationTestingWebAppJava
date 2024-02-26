package homework03;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.example.homework03.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class DummyTest extends AbstractTest {

    @Test
        // Домашнее задание 2: задача 1
    void loginWithOutAuthorizationTest() {


        LoginPage loginPageS3 = Selenide.page(LoginPage.class);
        loginPageS3.loginWithOutAuthorization();

        SelenideElement error = $x("//h2[@class='svelte-uwkxn9']").shouldBe(visible);
        Assertions.assertEquals("401", error.text());
    }
}