package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.TestBase;

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


        registrationPage.checkResult("Student Name", "Anna Volkova")
                .checkResult("Student Email", "anna@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "15 February,1988")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "selenide-logo-big.png")
                .checkResult("Address", "Narnia")
                .checkResult("State and City", "NCR Noida");

    }
}

