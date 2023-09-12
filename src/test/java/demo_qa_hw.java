import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import java.io.File;

public class demo_qa_hw {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void FormTest() {

        final String firstName = "Anna";
        final String lastName = "Volkova";
        final String email = "anna@gmail.com";
        final String userGender = "Male";
        final String mobile = "12345678901";
        final String yearOfBirth = "1988";
        final String monthOfBirth = "February";
        final String subjects = "English";
        final String hobbies = "Reading";
        File newFile = new File("src/test/java/selenide-logo-big.png");
        final String address = "Narnia";
        final String state = "NCR";
        final String city = "Noida";

        open("automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(userGender)).click();
        $("#userNumber").setValue(mobile);

        $(".react-datepicker__input-container").click();
        $(".react-datepicker__year-select").$(byText(yearOfBirth)).click();
        $(".react-datepicker__month-select").$(byText(monthOfBirth)).click();
        $(".react-datepicker__day--015").click();

        $("#subjectsWrapper").click();
        $("#subjectsInput").setValue(subjects).pressEnter();

        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("#uploadPicture").uploadFile(newFile);
        $("#currentAddress").setValue(address);

        $("#state").click();
        $("#state").$(byText(state)).click();

        $("#city").click();
        $("#city").$(byText(city)).click();

        $("#submit").click();

        //Проверки содержимого:
        $(".table-responsive").shouldHave(
                text("Anna Volkova"),
                text("anna@gmail.com"),
                text("Male"),
                text("12345678901"),
                text("15 February,1998"),
                text("English"),
                text("Reading"),
                text("selenide-logo-big.png"),
                text("Narnia"),
                text("NCR Noida"));

    }
}

