package Tests;

import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity extends TestBase{
    HomePageHelper homePage;
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    CurrentBoardPageHelper qaHaifa7currentBoard;
    MenuPageHelper menuPage;
    ActivityPageHelper activityPage;
    @BeforeMethod
    public void initTest(){
        loginPage= PageFactory.initElements(driver, LoginPageHelper.class);
        boardsPage=PageFactory.initElements(driver, BoardsPageHelper.class);
        qaHaifa7currentBoard = new CurrentBoardPageHelper(driver,"QAHaifa7");
        homePage =PageFactory.initElements(driver, HomePageHelper.class);
        menuPage= PageFactory.initElements(driver,MenuPageHelper.class);
        activityPage= PageFactory.initElements(driver,ActivityPageHelper.class);

        homePage.waitUntilHomePageLoaded().openLoginPage();
        loginPage.waitUntilLoginPageIsLoaded().loginAsAtlassian(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded().openCurrentBoardPage("QAHaifa7");
        qaHaifa7currentBoard.waitUntilPageIsLoaded().openMemberMenu();
        menuPage.waitUntilPageIsLoaded().openActivity();
        activityPage.waitUntilPageIsLoaded();
    }
    @Test
    public void isActivityPage(){
        Assert.assertEquals(activityPage.getActivityTabName(), "Activity");
    }

    @Test
    public void activityEventIsCorrect(){
        activityPage.backToCurrentBoard();
        qaHaifa7currentBoard.waitUntilPageIsLoaded();
        qaHaifa7currentBoard.addACard("NewCard").openMemberMenu().waitUntilPageIsLoaded();
        menuPage.waitUntilPageIsLoaded().openActivity();
        activityPage.waitUntilPageIsLoaded();
        System.out.println(activityPage.getTitleCardFromEvent());
        Assert.assertEquals(activityPage.getTitleCardFromEvent(),"NewCard");
    }

}
