package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage {
    private final SelenideElement usernameField = $x("//*[@name='username']");
    private final SelenideElement passwordField = $x("//*[@name='password']");
    private final SelenideElement submitPasswordField = $x("//*[@id='passwordSubmit']");
    private final SelenideElement showPasswordBtn = $x("//*[contains(@class, 'form__password-button') and @id='passwordBtn']");
    private final SelenideElement showSubmitPasswordBtn = $x("//*[contains(@class, 'form__password-button') and @id='passwordSubmitBtn']");
    private final SelenideElement registerBtn = $x("//*[@type='submit']");
    private final SelenideElement formError = $x("//*[@class='form__error']");
    private final SelenideElement formSuccessRegistration = $x("//*[contains(@class, 'form__paragraph_success')]");
    private final SelenideElement authBtn = $x("//*[@href='http://localhost:3001']");

    public RegistrationPage setUsername(String username) {
        usernameField.setValue(username);
        return this;
    }

    public RegistrationPage setPassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    public RegistrationPage setSubmitPassword(String password) {
        submitPasswordField.setValue(password);
        return this;
    }

    public RegistrationPage registrationBtnClick() {
        registerBtn.click();
        return new RegistrationPage();
    }

    public RegistrationPage successRegistrationAlertVisible() {
        formSuccessRegistration.shouldBe(Condition.visible);
        return this;
    }

    public RegistrationPage existUsernameErrorVisible(String errorText) {
        formError.shouldHave(text(errorText));
        return this;
    }

    public RegistrationPage differentPasswordsErrorVisible() {
        formError.shouldHave(text("Passwords should be equal"));
        return this;
    }
}
