package org.example.homework03;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.visible;

public class StudentRow {
    private final SelenideElement root;
    public StudentRow (SelenideElement root) {
        this.root = root;
    }

    public String getIdStudent() {
        return root.$x("./td[1]").shouldBe(visible).text();
    }

    public String getNameStudent() {
        return root.$x("./td[2]").shouldBe(visible).text();
    }

    public void clickEditButtonInRow() {
        root.$x("./td[7]/button[2]").shouldBe(visible).click();
    }

    public void clickCredentialButtonInRow() {
        root.$x("./td[7]/button[1]").shouldBe(visible).click();
    }

}