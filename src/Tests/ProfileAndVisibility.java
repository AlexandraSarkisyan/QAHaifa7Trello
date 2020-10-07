package Tests;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfileAndVisibility extends TestBase{
    HomePageHelper homePage;
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    CurrentBoardPageHelper qaHaifa7currentBoard;
    ProfileAndVisibilityPageHelper profileAndVisibilityPage;
    @BeforeMethod
    public void initTest() {
        loginPage= new LoginPageHelper(driver);
        boardsPage=new BoardsPageHelper(driver);
        qaHaifa7currentBoard = new CurrentBoardPageHelper(driver,"QAHaifa7");
        homePage =new HomePageHelper(driver);
        profileAndVisibilityPage=new ProfileAndVisibilityPageHelper(driver);

        homePage.waitUntilHomePageLoaded();
        homePage.openLoginPage();
        loginPage.waitUntilLoginPageIsLoaded();
        loginPage.loginAsAtlassian(LOGIN,PASSWORD);
        boardsPage.waitUntilBoardsPageIsLoaded();
        //Open QA7Haifa board
        boardsPage.openCurrentBoardPage("QAHaifa7");
        qaHaifa7currentBoard.waitUntilPageIsLoaded();
        //Open Profile&Visibility Page
        qaHaifa7currentBoard.openMemberMenu();
        qaHaifa7currentBoard.openProfileAndVisibilityPage();
    }
    @Test
    public void isProfileVisibilityPage(){
        Assert.assertEquals(profileAndVisibilityPage.isProfileAndVisibilityPage(), "Profile and Visibility");
    }
    @Test
    public void userNameVerification(){
        Assert.assertEquals(profileAndVisibilityPage.getUsernameOfTitleMenuButton(),
                profileAndVisibilityPage.getUsernameFieldContent(),"Username is not correct");
    }
}
