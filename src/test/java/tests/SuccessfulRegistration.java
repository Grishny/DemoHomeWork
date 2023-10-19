package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class SuccessfulRegistration extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Anna")
                .setLastName("Volkova")
                .setEmail("anna@gmail.com")
                .setGender("Male")
                .setNumber("1234567890")
                .setDateOfBirth("15", "February", "1988")
                .setSubjects("English")
                .setHobbies("Reading")
                .setPicture("selenide-logo-big.png")
                .setAddress("Narnia")
                .setState("NCR")
                .setCity("Noida")
                .clickOnTheRegistrationButton();


        registrationPage.checkResultTest("Student Name", "Anna Volkova")
                .checkResultTest("Student Email", "anna@gmail.com")
                .checkResultTest("Gender", "Male")
                .checkResultTest("Mobile", "1234567890")
                .checkResultTest("Date of Birth", "15 February,1988")
                .checkResultTest("Subjects", "English")
                .checkResultTest("Hobbies", "Reading")
                .checkResultTest("Picture", "selenide-logo-big.png")
                .checkResultTest("Address", "Narnia")
                .checkResultTest("State and City", "NCR Noida");

    }
}

