package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage {
    private final SelenideElement usernameField = $x("//*[@name='username']");
    private final SelenideElement passwordField = $x("//*[@name='password']");
    private final SelenideElement submitPasswordField = $("#passwordSubmit");
    private final SelenideElement showPasswordBtn = $(".form__password-button#password");
    private final SelenideElement showSubmitPasswordBtn = $(".form__password-button#passwordSubmit");
    private final SelenideElement registerBtn = $x("//*[@type='submit']");
    private final SelenideElement successRegistrationAlert = $x("//p[text() = \"Congratulations! You've registered!\"]");
    private final SelenideElement existUsernameAlert = $x("//span[contains(text(), \"Username\")and contains(text(), \"already exists\")]");
    private final SelenideElement notMatchPasswordAlert = $x("//span[contains(text(), \"Passwords should be equal\")]");
    private final SelenideElement authBtn = $x("//*[@href='http://localhost:3001']");

    public RegistrationPage setUsername(String username){
        usernameField.setValue(username);
        return this;
    }

    public RegistrationPage setPassword(String password){
        passwordField.setValue(password);
        return this;
    }

    public RegistrationPage setSubmitPassword(String password){
        submitPasswordField.setValue(password);
        return this;
    }

    public RegistrationPage showPasswordBtnClick(){
        showPasswordBtn.click();
        return this;
    }

    public RegistrationPage showSubmitPasswordBtnClick(){
        showSubmitPasswordBtn.click();
        return this;
    }

    public RegistrationPage registrationBtnClick(){
        registerBtn.click();
        return new RegistrationPage();
    }

    public RegistrationPage loginBtnClick(){
        authBtn.click();
        return new RegistrationPage();
    }

    public RegistrationPage successRegistrationAlertVisible(){
        successRegistrationAlert.shouldBe(Condition.visible);
        return this;
    }

    public RegistrationPage existUsernameAlertVisible(){
        existUsernameAlert.shouldBe(Condition.visible);
        return this;
    }

    public RegistrationPage notMatchPasswordAlertVisible(){
        notMatchPasswordAlert.shouldBe(Condition.visible);
        return this;
    }
}
