package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

        @Test
        void successfulRegistrationTest() {
            registrationPage.openPage()
                    .setFirstName("Alex")
                    .setLastName("Egorov")
                    .setEmail("alex@egorov.com")
                    .setGender("Other")
                    .setUserNumber("1234567890")
                    .setDateOfBirth("30", "July", "2008")
                    .setSubject("Maths")
                    .setHobby("Sports")
                    .selectPicture("img/1.png")
                    .setAddress("Fhvxk 322")
                    .setStateAndCity("NCR","Delhi")
                    .clickSubmit();

            registrationPage.checkSpreadsheetWithResults()
                    .checkResult("Student Name", "Alex Egorov")
                    .checkResult("Student Email", "alex@egorov.com")
                    .checkResult("Mobile", "1234567890");

        }

    @Test
    void successfulIncompleteRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setGender("Other")
                .setUserNumber("1234567890")
                .setDateOfBirth("30", "July", "2008")
                .setAddress("Fhvxk 322")
                .setStateAndCity("NCR","Delhi")
                .clickSubmit();

        registrationPage.checkSpreadsheetWithResults()
                .checkResult("Student Name", "Alex Egorov")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "1234567890")
                .checkEmptyResult("Student Email","")
                .checkEmptyResult("Subjects","")
                .checkEmptyResult("Hobbies","")
                .checkEmptyResult("Picture","");

    }

    @Test
    void negativeRegistrationTestWithoutLastName() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setEmail("alex@egorov.com")
                .setGender("Other")
                .setUserNumber("1234567890")
                .setDateOfBirth("30", "July", "2008")
                .setSubject("Maths")
                .setHobby("Sports")
                .selectPicture("img/1.png")
                .setAddress("Fhvxk 322")
                .setStateAndCity("NCR","Delhi")
                .clickSubmit();

        registrationPage.checkSpreadsheetWithResultsMissing();

    }

    @Test
    void negativeRegistrationTestWithoutGender() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setEmail("alex@egorov.com")
                .setUserNumber("1234567890")
                .setDateOfBirth("30", "July", "2008")
                .setSubject("Maths")
                .setHobby("Sports")
                .selectPicture("img/1.png")
                .setAddress("Fhvxk 322")
                .setStateAndCity("NCR","Delhi")
                .clickSubmit();

        registrationPage.checkSpreadsheetWithResultsMissing();

    }

    }
