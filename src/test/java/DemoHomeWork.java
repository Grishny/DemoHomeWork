import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoHomeWork {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void formTest() {

        final String firstName = "Anna";
        final String lastName = "Volkova";
        final String email = "anna@gmail.com";
        final String userGender = "Male";
        final String mobile = "1234567890";
        final String yearOfBirth = "1988";
        final String monthOfBirth = "February";
        final int dayOfBirth = 15;
        final String filePath = "selenide-logo-big.png";
        final String subjects = "English";
        final String hobbies = "Reading";
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
        $("#uploadPicture").uploadFromClasspath(filePath);
        $("#currentAddress").setValue(address);

        $("#state").click();
        $("#state").$(byText(state)).click();

        $("#city").click();
        $("#city").$(byText(city)).click();

        $("#submit").click();

        //Проверки содержимого:
        $(".modal-content").shouldHave
                                            (text(firstName + " " + lastName) ,
                                            text(email),
                                            text(userGender),
                                            text(mobile),
                                            text(dayOfBirth+" "+monthOfBirth+","+yearOfBirth),
                                            text(subjects),
                                            text(hobbies),
                                            text(filePath),
                                            text(address),
                                            text(state+" "+city));
    }
}

