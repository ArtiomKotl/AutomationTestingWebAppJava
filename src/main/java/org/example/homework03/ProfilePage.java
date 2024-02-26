package org.example.homework03;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class ProfilePage {
    @FindBy(xpath = "//h2[@class='mdc-typography--headline6 svelte-vyyzan']")
    private SelenideElement h2fullName;
    @FindBy(xpath = "//h3/following-sibling::div" +
            "//div[contains(text(), 'Full name')]/following-sibling::div")
    private SelenideElement fullName;
    private final SelenideElement dateOfBirth = $x("//div[contains(text(), " +
            "'Date of birth')]/following-sibling::div");
    private final SelenideElement editProfile = $("button[title='More options']");
    private final SelenideElement newAvatarImageInput = $("input[type='file']");

    private final SelenideElement saveProfileUpdateData = $("button[type='submit']");
    private final SelenideElement newBirthDayDateInput = $("input[type='date']");
    private final SelenideElement closeWidowEditingProfile = $("button[data-mdc-dialog-action='close']");

    public String getH2FullNameText () {
        return h2fullName.shouldBe(visible).text();
    }

    public String getFullNameText () {
        return fullName.shouldBe(visible).text();
    }

    public String getDayOfBirthText() {return dateOfBirth.shouldBe(visible).text();}

    public void clickEditProfile () {
        editProfile.shouldBe(visible).click();
    }
    public void uploadNewAvatarImage (String pathToFile) {
        newAvatarImageInput.shouldBe(visible).uploadFile(new File(pathToFile));
    }
    public String getUploadFileName() {
        return newAvatarImageInput.getValue();
    }
    public void uploadnewBirthDayDate(String date) {
        newBirthDayDateInput.shouldBe(visible).setValue(date);}
    public void clickSaveProfileUpdateData () {
        saveProfileUpdateData.shouldBe(visible, Duration.ofMillis(2000L)).click();
    }
    public void clickCloseWidowEditingProfile() {
        closeWidowEditingProfile.shouldBe(visible).click();
    }
}