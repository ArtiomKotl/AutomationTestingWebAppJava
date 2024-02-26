package org.example.homework03;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final SelenideElement loginField = $x("//*[@type='text']");

    private final SelenideElement passwordField = $x("//*[@type='password']");

    private final SelenideElement button = $("form#login button");


    public void loginInSystem(String login, String password) {
        loginField.shouldBe(visible).setValue(login);
        passwordField.shouldBe(visible).setValue(password);
        button.shouldBe(visible).click();
    }

    public void loginWithOutAuthorization() {
        button.shouldBe(visible).click();
    }

}
