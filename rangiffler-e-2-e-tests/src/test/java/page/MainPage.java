package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement rangifflerLogo = $("href='/my-travels'");
    private final SelenideElement menuBtn = $("data-testid='AccountCircleRoundedIcon'");
    private final SelenideElement travelsBtn = $("data-testid='PublicRoundedIcon'");
    private final SelenideElement peoplesBtn = $("data-testid='PersonSearchRoundedIcon'");
    private final SelenideElement logoutBtn = $("data-testid='ExitToAppOutlinedIcon'");
    private final SelenideElement addPhotoBtn = $x("//button[text()='Add photo']");
    private final SelenideElement onlyMyTravelsBtn = $x("//button[text()='Only my travels']");
    private final SelenideElement withFriendsTravelsBtn = $x("//button[text()='With friends']");
    private final SelenideElement map = $(".worldmap__figure-container");
    private final ElementsCollection countryCards = $$x("//*[@class='photo-card__image']/..");

    public MainPage mapShouldBeVisible(){
        map.shouldBe(Condition.visible);
        return this;
    }

    public void mapShouldBeNotVisible(){
        map.shouldNotBe(Condition.visible);
    }

    public MainPage editCountryCard(int cardIndex){
        countryCards.get(cardIndex).$x("//button[text()='Edit']").click();
        return this;
    }
}
