package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AuthPage {
    private final SelenideElement loginBtn = $x("//button[text()='Login']");
    private final SelenideElement registerBtn = $x("//a[text()='Register']");

    public LoginPage loginBtnClick() {
        loginBtn.click();
        return new LoginPage();
    }

    public RegistrationPage registerBtnClick() {
        registerBtn.click();
        return new RegistrationPage();
    }
}
