package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class SuccessfulRegistrationTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData data = new TestData();
    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.userEmail)
                .setGender(data.gender)
                .setNumber(data.numberPhone)
                .setDateOfBirth(data.dayOfBirth, data.monthOfBirth, data.yearOfBirth)
                .setSubjects(data.subjects)
                .setHobbies(data.hobbies)
                .setPicture("img/" + data.img)
                .setAddress(data.address)
                .setState(data.state)
                .setCity(data.city)
                .clickOnTheRegistrationButton();


        registrationPage.checkResultTest("Student Name", data.firstName + " " + data.lastName)
                .checkResultTest("Student Email", data.userEmail)
                .checkResultTest("Gender", data.gender)
                .checkResultTest("Mobile", data.numberPhone)
                .checkResultTest("Date of Birth", data.dayOfBirth + " " + data.monthOfBirth + "," + data.yearOfBirth)
                .checkResultTest("Subjects", data.subjects)
                .checkResultTest("Hobbies", data.hobbies)
                .checkResultTest("Picture", data.img)
                .checkResultTest("Address", data.address)
                .checkResultTest("State and City", data.state + " " + data.city);

    }
}

