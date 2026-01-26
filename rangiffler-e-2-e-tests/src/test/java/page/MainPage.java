package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement rangifflerLogo = $x("//*[@href='/my-travels']");
    private final SelenideElement menuBtn = $x("//*[@data-testid='AccountCircleRoundedIcon']");
    private final SelenideElement travelsBtn = $x("//*[@data-testid='PublicRoundedIcon']");
    private final SelenideElement peoplesBtn = $x("//*[@data-testid='PersonSearchRoundedIcon']");
    private final SelenideElement logoutBtn = $x("//*[@data-testid='ExitToAppOutlinedIcon']");
    private final SelenideElement addPhotoBtn = $x("//button[text()='Add photo']");
    private final SelenideElement onlyMyTravelsBtn = $x("//button[text()='Only my travels']");
    private final SelenideElement withFriendsTravelsBtn = $x("//button[text()='With friends']");
    private final SelenideElement map = $x(".//*[@class = 'worldmap__figure-container']");
    private final ElementsCollection countryCards = $$x("//*[@class='photo-card__image']/..");

    public MainPage mapShouldBeVisible() {
        map.shouldBe(Condition.visible);
        return this;
    }

}
