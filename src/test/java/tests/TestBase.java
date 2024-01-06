package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.LoginPage;
import pages.RegistrationPage;

    public class TestBase {

        @BeforeAll
        static void beforeAll() {
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.browserSize = "1920x1080";
//          Configuration.browser = "chrome";
            Configuration.timeout = 1000;
            Configuration.holdBrowserOpen = false;
        }

        @AfterEach
        void afterEach() {
            Selenide.closeWebDriver();
        }


    }

