package Tests;
import Pages.BoardsPageHelper;
import Pages.CurrentBoardPageHelper;
import Pages.HomePageHelper;
import Pages.LoginPageHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CurrentBoardTests extends TestBase {
    HomePageHelper homePage;
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    CurrentBoardPageHelper qaHaifa7currentBoard;

    @BeforeMethod
    public void initTest() {
        //preferences
        loginPage= new LoginPageHelper(driver);
        boardsPage=new BoardsPageHelper(driver);
        qaHaifa7currentBoard = new CurrentBoardPageHelper(driver,"QAHaifa7");
        homePage =new HomePageHelper(driver);

        homePage.waitUntilHomePageLoaded();
        homePage.openLoginPage();
        loginPage.waitUntilLoginPageIsLoaded();
        loginPage.loginAsAtlassian(LOGIN,PASSWORD);
        boardsPage.waitUntilBoardsPageIsLoaded();
        //Open QA7Haifa board
        boardsPage.openCurrentBoardPage("QAHaifa7");
        qaHaifa7currentBoard.waitUntilPageIsLoaded();
    }
    @Test
    public void isCorrectCurrentBoard(){
        Assert.assertEquals(qaHaifa7currentBoard.getCurrentBoardHeader(),"QAHaifa7",
                "The header of the screen is not 'QAHaifa7'");
    }

    @Test
    public void isCorrectCurrentBoard2(){
        Assert.assertTrue(qaHaifa7currentBoard.isCorrectCurrentBoard(),
                "The header of the screen is not 'QA Haifa7'");
    }
    @Test
    public void addNewListPositiveTest() {
        //Add new list to the board
        int quantityListsInTheBeginning = qaHaifa7currentBoard.getQuantityLists();
        qaHaifa7currentBoard.addNewListToCurrentBoard("Test");
        int quantityListsAtTheEnd= qaHaifa7currentBoard.getQuantityLists();
        Assert.assertEquals(quantityListsAtTheEnd, quantityListsInTheBeginning +1, "The quantityListsAtTheEnd is not quantityListsInTheBeginning-1 ");
    }

    @Test
    public void putAnyListToArchive() {
        //If there are no lists create the new list
        if (qaHaifa7currentBoard.getTextAddListButton().equals("Add a list")) {
            qaHaifa7currentBoard.addNewListToCurrentBoard("First list");
        }
        int quantityListsInTheBeginning = qaHaifa7currentBoard.getQuantityLists();
        System.out.println("Text on the button: " + qaHaifa7currentBoard.getTextAddListButton());
        qaHaifa7currentBoard.openListMenu();
        qaHaifa7currentBoard.putListToTheArchive();
        int quantityListsAtTheEnd = qaHaifa7currentBoard.getQuantityLists();
        Assert.assertEquals(quantityListsAtTheEnd, quantityListsInTheBeginning - 1, "The quantityListsAtTheEnd is not quantityListsInTheBeginning-1 ");
    }
}