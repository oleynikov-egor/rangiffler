package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AuthPage {
    private final SelenideElement loginBtn = $(By.xpath("//button[text()='Login']"));
    private final SelenideElement registerBtn = $(By.xpath("//a[text()='Register']"));

    public LoginPage loginBtnClick(){
        loginBtn.click();
        return new LoginPage();
    }

    public RegistrationPage registerBtnClick(){
        registerBtn.click();
        return new RegistrationPage();
    }

    public AuthPage loginBtnShouldBeVisible(){
        loginBtn.shouldBe(Condition.visible);
        return this;
    }

    public AuthPage registerBtnShouldBeVisible(){
        registerBtn.shouldBe(Condition.visible);
        return this;
    }
}
