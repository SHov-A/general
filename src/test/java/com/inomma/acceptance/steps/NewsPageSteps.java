package com.inomma.acceptance.steps;

import com.inomma.acceptance.exception.StarTrekException;
import com.inomma.acceptance.helper.TestUtil;
import com.inomma.acceptance.pages.NewsPage;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NewsPageSteps {

    private static List<WebElement> newsCards;
    private static int arrayOfNewsSize;
    private final Logger logger = Logger.getLogger(NewsPageSteps.class);

    @Autowired
    private NewsPage newsPage;

    // game information category
    @Then("^In News Page - I click on Game information category$")
    public void In_News_Page_I_click_on_Game_information_category() {
        newsPage.clickOnGameInformation();
    }

    @Then("^In News Page - I click on Show More button if its exists$")
    public void In_News_Page_I_click_on_Show_More_button_if_its_exists() {
        try {
            if (newsPage.getMoreNews()) newsPage.clickOnShowMoreButton();
        } catch (TimeoutException e) {
            DOMConfigurator.configure("log4j.xml");
            logger.info("In news aren't load button");
        }
    }

    @Then("^In News Page - I get the list of news of category Game information contain \"([^\"]*)\" text$")
    public void In_News_Page_I_get_the_list_of_news_of_category_Game_information_contain(String text) {
        newsCards = newsPage.getNewsCardDivs();
        arrayOfNewsSize = newsCards.size();
        for (int i = 0; i < arrayOfNewsSize; i++) {
            Assert.assertEquals(newsCards.get(i).findElement(newsPage.getGameInformationHashTag()).getText(), text);
        }
    }

    @Then("^In News Page - I click on any of Game Information hashtag$")
    public void In_News_Page_I_click_on_any_of_Game_Information_hashtag() {
        int randomNews = TestUtil.randomNumberGenerator(arrayOfNewsSize);
        newsCards.get(randomNews).findElement(newsPage.getGameInformationHashTag()).click();
    }

    @Then("^In New Window - I see Game Information \"([^\"]*)\" URL$")
    public void In_New_Window_I_see_Game_Information_URL(String text) {
        Assert.assertEquals(text, newsPage.redirectURL());
    }

    // news category
    @Then("^In News Page - I click on News category$")
    public void In_News_Page_I_click_on_News_category() {
        newsPage.clickOnNewsCategory();
    }

    @Then("^In News Page - I get the list of news of category News contain \"([^\"]*)\" text$")
    public void In_News_Page_I_get_the_list_of_news_of_category_News_contain(String text) {
        newsCards = newsPage.getNewsCardDivs();
        arrayOfNewsSize = newsCards.size();
        for (int i = 0; i < arrayOfNewsSize; i++) {
            Assert.assertEquals(newsCards.get(i).findElement(newsPage.getNewsHashTag()).getText(), text);
        }
    }

    @Then("^In News Page - I click on any of News hashtag$")
    public void In_News_Page_I_click_on_any_of_News_hashtag() {
        int randomNews = TestUtil.randomNumberGenerator(arrayOfNewsSize);
        newsCards.get(randomNews).findElement(newsPage.getNewsHashTag()).click();
    }

    @Then("^In New Window - I see News \"([^\"]*)\" URL$")
    public void In_New_Window_I_see_News_URL(String text) {
        Assert.assertEquals(text, newsPage.redirectURL());
    }

    //community category
    @Then("^In News Page - I click on Community  category$")
    public void In_News_Page_I_click_on_Community_category() {
        newsPage.clickOnCommunityCategory();
    }

    @Then("^In News Page - I get the list of news of category Community contain \"([^\"]*)\" text$")
    public void In_News_Page_I_get_the_list_of_news_of_category_Community_contain(String text) {
        newsCards = newsPage.getNewsCardDivs();
        arrayOfNewsSize = newsCards.size();
        for (int i = 0; i < arrayOfNewsSize; i++) {
            Assert.assertEquals(text, newsCards.get(i).findElement(newsPage.getCommunityHashTag()).getText());
        }
    }

    @Then("^In News Page - I click on any of Community hashtag$")
    public void In_News_Page_I_click_on_any_of_Community_hashtag() {
        int randomNews = TestUtil.randomNumberGenerator(arrayOfNewsSize);
        newsCards.get(randomNews).findElement(newsPage.getCommunityHashTag()).click();
    }

    @Then("^In New Window - I see Community \"([^\"]*)\" URL$")
    public void In_New_Window_I_see_Community_URL(String text) {
        Assert.assertEquals(text, newsPage.redirectURL());
    }

    //main news and first news should be the same
    @Then("^In News Page - I get main news title and compare it with first news title$")
    public void In_News_Page_I_get_main_news_title_and_compare_it_with_first_news_title() throws InterruptedException {
        Thread.sleep(300);
        Assert.assertEquals(newsPage.getMainNewsTitle(), newsPage.getFirstNewsTitle());
    }

    //Latest In Game News section for Log-out user
    @Then("^In News Page - I try to find Latest In-game News section$")
    public void In_News_Page_I_try_to_find_Latest_In_Game_News_section() {
        try {
            if (newsPage.getLatestInGameNewsSection()) {
                throw new StarTrekException("This section should not be active for log out user");
            }
        } catch (TimeoutException e) {
            DOMConfigurator.configure("log4j.xml");
            logger.info("The user is logged out");
        }
    }

    //Latest In Game News- section functionality checking for logged-in user
    @Then("^In News Page - I get the list of In game news and check if the name is equal to main news after clicking$")
    public void In_News_Page_I_get_the_list_of_In_game_news_and_check_if_the_name_is_equal_to_main_news_after_clicking() {
        try {
            if (newsPage.getLatestInGameNewsSection()) {
                List<WebElement> inGameNewsCard = newsPage.getInGameNewsCardDiv();
                int arrayOfInGameNewsSize = inGameNewsCard.size();
                for (int i = 0; i < arrayOfInGameNewsSize; i++) {
                    inGameNewsCard.get(i).click();
                    Assert.assertEquals(newsPage.getLatestInGameNewsBannerText(), inGameNewsCard.get(i).findElement(newsPage.getLatestInGameNewsCard()).getText());
                }
            }
        } catch (TimeoutException e) {
            DOMConfigurator.configure("log4j.xml");
            logger.info("The user doesn't have in game news");
        }
    }
}

