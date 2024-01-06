package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.SpreadsheetComponent;
import pages.components.StateCityComponent;
import tests.TestBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage extends TestBase {

    ///// SelenideElements
    CalendarComponent calendar = new CalendarComponent();
    StateCityComponent stateCity = new StateCityComponent();

    SpreadsheetComponent spreadsheet = new SpreadsheetComponent();

    SelenideElement titleLabel = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            hobbyWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            submit = $("#submit");


    ///// Actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        titleLabel.shouldHave(text("Student Registration Form"));
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
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate("30", "July", "2008");

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.$(byText(value)).pressEnter();

        return this;
    }

    public RegistrationPage setHobby(String value) {
        hobbyWrapper.$(byText(value)).pressEnter();

        return this;
    }

    public RegistrationPage selectPicture(String fileName) {
        uploadPicture.uploadFromClasspath(fileName);

        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        stateCity.setStateCity(state,city);

        return this;
    }

    public RegistrationPage clickSubmit() {
        submit.click();

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    public RegistrationPage checkEmptyResult(String key) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldBe(empty);

        return this;
    }
    public RegistrationPage checkSpreadsheetWithResultsMissing() {
        spreadsheet.checkSpreadsheetMissing();
        return this;
    }

    public RegistrationPage checkSpreadsheetWithResults() {
        spreadsheet.checkSpreadsheet();

        return this;
    }

}
