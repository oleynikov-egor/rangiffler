package tests;

import com.codeborne.selenide.Selenide;
import config.Config;
import jupiter.User;
import model.UserJson;
import org.junit.jupiter.api.Test;
import page.AuthPage;

public class LoginTests {
    private final Config config = Config.getInstance();

    @Test
    public  void userShouldStayOnLoginPageAfterLoginWithBadCredentials(){
        Selenide.open(config.frontUrl(), AuthPage.class)
                .loginBtnClick()
                .setUsername("Bob")
                .setPassword("john")
                .loginBtnClick()
                .mapShouldBeNotVisible();
    }

    @User
    @Test
    public  void mainPageShouldBeDisplayedAfterSuccessLogin(UserJson userJson){
        Selenide.open(config.frontUrl(), AuthPage.class)
                .loginBtnClick()
                .setUsername(userJson.username())
                .setPassword(userJson.password())
                .loginBtnClick()
                .mapShouldBeVisible();
    }
}
