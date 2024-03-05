package org.example.homework03;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class EditingDummyPage {
    private final SelenideElement firstNameInputField = $x(
            "//form[@id='upsert-item']/div[1]/label/input");
    private final SelenideElement saveButton = $("button[form='upsert-item']");
    private final SelenideElement newBirthDayDateInput = $("input[type='date']");
    private final SelenideElement dateOfBirth = $x("//div[contains(text(), " +
            "'Date of birth')]/following-sibling::div");

    public String getDayOfBirthText() {return dateOfBirth.shouldBe(visible).text();}

    public void ChangeDummyFirstName(String name) {



        firstNameInputField.shouldBe(visible).setValue(name);
        saveButton.shouldBe(visible).click();
    }

    public void uploadNewBirthDayDate(String date) {
        newBirthDayDateInput.shouldBe(visible).setValue(date);}


}
