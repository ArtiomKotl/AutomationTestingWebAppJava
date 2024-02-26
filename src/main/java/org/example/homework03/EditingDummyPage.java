package org.example.homework03;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class EditingDummyPage {
    private final SelenideElement firstNameInputField = $x(
            "//form[@id='upsert-item']/div[1]/label/input");
    private final SelenideElement saveButton = $("button[form='upsert-item']");

    public void ChangeDummyFirstName(String name) {



        firstNameInputField.shouldBe(visible).setValue(name);
        saveButton.shouldBe(visible).click();
    }


}
