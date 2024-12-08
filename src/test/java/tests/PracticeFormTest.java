package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


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
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

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
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("label[for='hobbies-checkbox-2']").click();


        $("#currentAddress").setValue("test currentAddress");

        //State and City
        $("#state").click();
        $x("//*[contains(text(),'Haryana')]").click();

       $("#city").click();
       $x("//*[contains(text(),'Panipat')]").click();

        //Picture
        $("#uploadPicture").uploadFile(new File("src/test/resources/testimg.jpg"));
        $("#submit").click();

         //Modal
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Kate M"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("test@test.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8805700114"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("11 November,2024"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("testimg.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("test currentAddress"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Haryana Panipat"));
        $("#closeLargeModal").click();

    }
}
