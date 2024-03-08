package homework04;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.example.homework03.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class DummyTest extends AbstractTest {

    @Test
    void loginWithOutAuthorizationTest() {
        LoginPage loginPage = Selenide.page(LoginPage.class);
        loginPage.loginWithOutAuthorization();
        Selenide.sleep(5000);

        SelenideElement error = $x("//h2[@class='svelte-uwkxn9']").shouldBe(visible);
        Assertions.assertEquals("401", error.text());
        Selenide.sleep(5000);
    }
}