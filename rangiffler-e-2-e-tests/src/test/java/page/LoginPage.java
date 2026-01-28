package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final SelenideElement usernameField = $x("//*[@name='username']");
    private final SelenideElement passwordField = $x("//*[@name='password']");
    private final SelenideElement showPasswordBtn = $x("//*[@class='form__password-button']");
    private final SelenideElement loginBtn = $x("//*[@type='submit']");
    private final SelenideElement registerBtn = $x("//*[@href='/register']");
    private final SelenideElement formError = $x("//*[@class='form__error']");

    public LoginPage setUsername(String username) {
        usernameField.setValue(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    public MainPage loginBtnClick() {
        loginBtn.click();
        return new MainPage();
    }

    public LoginPage loginBtnWithBadCredentialsClick() {
        loginBtn.click();
        formError.shouldHave(text("Неверные учетные данные пользователя"));
        return this;
    }
}
