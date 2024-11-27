package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class PracticeFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true; //чтобы браузер не закрывался
        Configuration.timeout = 5000; // default 4000
    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Kate");
        $("#lastName").setValue("M");
        $("#userEmail").setValue("test@test.com");
        $("label[for='gender-radio-2']").click();
        $("#userNumber").setValue("88057001144");

        //Date of Birth
        $("#dateOfBirthInput").click();
        // Выбор года
        $(".react-datepicker__year-select").selectOption("2024");

        // Выбор месяца
        $(".react-datepicker__month-select").selectOption("November");

        // Выбор дня
        $(".react-datepicker__day--011").click();

        //Subjects
        $("label[for='hobbies-checkbox-2']").click();

        //Picture
        $("#currentAddress").setValue("test currentAddress");
        //State and City

    }
}
