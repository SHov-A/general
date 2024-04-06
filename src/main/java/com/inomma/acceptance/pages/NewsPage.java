package com.inomma.acceptance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * News Page's related web elements and actions with them.
 */
public class NewsPage extends BasePage {

    private final By gameInformationHashTag = By.name("news-category-button-game-information");
    private final By newsHashTag = By.name("news-category-button-news");
    private final By communityHashTag = By.name("news-category-button-community");
    private final By latestInGameNewsCard = By.name("in-game-news-card-title");

    @FindBy(id = "news-category-button-game-information")
    private WebElement gameInformationNewsCategory;

    @FindBy(id = "news-category-button-news")
    private WebElement newsCategory;

    @FindBy(id = "news-category-button-community")
    private WebElement communityNewsCategory;

    @FindBy(id = "news-category-button-all")
    private WebElement allNewsCategory;

    @FindBy(name = "news-card")
    private List<WebElement> newsCardDiv;

    @FindBy(xpath = "//div[@id='news-banner']//h1")
    private WebElement mainNews;

    @FindBy(xpath = "//div[@name='news-card'][1]//p[2]")
    private WebElement firstNews;

    @FindBy(name = "in-game-news-card")
    private List<WebElement> inGameNewsCardDiv;

    @FindBy(xpath = "//div[@name='in-game-news-card']//p[2]")
    private WebElement latestInGameMainNewsCard;

    @FindBy(id = "in-game-news-title")
    private WebElement latestInGameNews;

    @FindBy(xpath = "//div[@name='in-game-news-banner']//p[2]")
    private WebElement latestInGameNewsBanner;

    @FindBy(id = "show-more-news-button")
    private WebElement showMoreNews;

    public NewsPage(PageContext pageContext) {
        super(pageContext);
    }

    public void clickOnGameInformation() {
        waitToElementIsClickable(gameInformationNewsCategory).click();
    }

    public void clickOnNewsCategory() {
        waitToElementIsClickable(newsCategory).click();
    }

    public void clickOnCommunityCategory() {
        waitToElementIsClickable(communityNewsCategory).click();
    }

    public void clickOnShowMoreButton() {
        waitToElementIsClickable(showMoreNews).click();
    }

    public boolean getMoreNews() {
        return waitToWebElement(showMoreNews);
    }

    public List<WebElement> getNewsCardDivs() {
        return visibilityOfAllElements(newsCardDiv);
    }

    public List<WebElement> getInGameNewsCardDiv() {
        return visibilityOfAllElements(inGameNewsCardDiv);
    }

    public By getGameInformationHashTag() {
        return gameInformationHashTag;
    }

    public By getNewsHashTag() {
        return newsHashTag;
    }

    public By getCommunityHashTag() {
        return communityHashTag;
    }

    public By getLatestInGameNewsCard() {
        return latestInGameNewsCard;
    }

    public String getLatestInGameMainNewsText() {
        return visibilityOf(latestInGameMainNewsCard).getText();
    }

    public String getFirstNewsTitle() {
        return visibilityOf(firstNews).getText();
    }

    public String getMainNewsTitle() {
        return visibilityOf(mainNews).getText();
    }

    public boolean getLatestInGameNewsSection() {
        return waitToWebElement(latestInGameNews);
    }

    public String getLatestInGameNewsBannerText() {
        return visibilityOf(latestInGameNewsBanner).getText();
    }

}
