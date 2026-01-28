package tests;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import config.Config;
import org.junit.jupiter.api.Test;
import page.AuthPage;

public class RegistrationTests {
    private final Config config = Config.getInstance();

    @Test
    void shouldRegisterNewUser() {
        String password = Faker.instance().internet().password(4, 12);
        Selenide.open(config.frontUrl(), AuthPage.class)
                .registerBtnClick()
                .setUsername(Faker.instance().elderScrolls().firstName())
                .setPassword(password)
                .setSubmitPassword(password)
                .registrationBtnClick()
                .successRegistrationAlertVisible();
    }

    @Test
    void shouldNotRegisterUserWithExistingUsername() {
        String password = Faker.instance().internet().password(4, 12);
        Selenide.open(config.frontUrl(), AuthPage.class)
                .registerBtnClick()
                .setUsername("Bob")
                .setPassword(password)
                .setSubmitPassword(password)
                .registrationBtnClick()
                .existUsernameErrorVisible("Username `Bob` already exists");
    }

    @Test
    void shouldShowErrorIfPasswordAndConfirmPasswordAreNotEqual() {
        Selenide.open(config.frontUrl(), AuthPage.class)
                .registerBtnClick()
                .setUsername(Faker.instance().elderScrolls().firstName())
                .setPassword(Faker.instance().elderScrolls().city())
                .setSubmitPassword(Faker.instance().gameOfThrones().city())
                .registrationBtnClick()
                .differentPasswordsErrorVisible();
    }
}
