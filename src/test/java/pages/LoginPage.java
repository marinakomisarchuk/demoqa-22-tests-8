package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    SelenideElement titleLabel = $(".login-wrapper"),
            userNameInput = $("#userName"),
            passwordInput = $("#password"),
            loginButton = $("#login");



    public LoginPage openPage() {
        open("/login");
        titleLabel.shouldHave(text("Welcome,"));
        titleLabel.shouldHave(text("Login in Book Store"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public LoginPage setUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public LoginPage setPassword(String value) {
        passwordInput.setValue(value);

        return this;
    }

    public LoginPage clickLogin() {
        loginButton.click();

        return this;
    }

    public LoginPage checkResult(String userName) {
        $(".pattern-backgound playgound-header").shouldHave(text("Profile"));
        $("#userName-value").shouldHave(text(userName));

        return this;
    }

    public LoginPage checkNegativeResult() {
        $("#name").shouldHave(text("Invalid username or password!"));

        return this;
    }

}
