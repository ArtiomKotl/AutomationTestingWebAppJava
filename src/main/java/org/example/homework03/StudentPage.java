package org.example.homework03;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;


public class StudentPage {
    private final SelenideElement userButton = $x(
            "//li[@class='svelte-1rc85o5 mdc-menu-surface--anchor']/a");
    private final SelenideElement profileButton = $x("//ul[@role='menu']/li");

    private final ElementsCollection studentsTable = $$x("//tbody[@class='mdc-data-table__content']/tr");

    public void editStudent(String id) {
        getStudentRowById(id).clickEditButtonInRow();
    }

    public void checkStudent(String id) {
        getStudentRowById(id).clickCredentialButtonInRow();
    }

    public String getStudentNameById(String id) {
        return getStudentRowById(id).getNameStudent();
    }

    private StudentRow getStudentRowById(String id) { // Получаем конкретного студента по id
        return getListWebElements(studentsTable.shouldHave(sizeGreaterThan(0)))
                .stream()
                .map(StudentRow::new)
                .filter(row -> row.getIdStudent().equals(id)).findFirst().orElseThrow();
    }

    private List<StudentRow> getStudentListRow() { // Получаем список строк студентов
        return getListWebElements(studentsTable.shouldHave(sizeGreaterThan(0)))
                .stream()
                .map(StudentRow::new).toList();
    }

    private List<SelenideElement> getListWebElements(ElementsCollection table) {
        List<SelenideElement> StudentsList = new ArrayList<>();
        for (SelenideElement element : table) {
            StudentsList.add(element);
        }
        return StudentsList;
    }

    public void openProfile() {
        userButton.shouldBe(visible).click();
        profileButton.shouldBe(visible).click();
    }
}
