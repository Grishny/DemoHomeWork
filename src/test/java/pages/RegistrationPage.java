package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultsModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    // TestComponents
    CalendarComponent calendar = new CalendarComponent();
    ResultsModal resultsModal = new ResultsModal();

    //SelenideElements
    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGenderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            fieldCalendar = $(".react-datepicker__input-container"),
            fieldSubjects = $("#subjectsWrapper"),
            subjectsInput = $("#subjectsInput"),
            fieldHobbies = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            buttonSubmit = $("#submit");

    //Actions
    public RegistrationPage openPage() {
        open("automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        userGenderInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        fieldCalendar.click();
        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        fieldSubjects.click();
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        fieldHobbies.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.click();
        stateInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.click();
        cityInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage clickOnTheRegistrationButton() {
        buttonSubmit.click();

        return this;
    }

    public RegistrationPage checkResultTest(String key, String value) {
        resultsModal.checkResult(key, value);

        return this;
    }

};



