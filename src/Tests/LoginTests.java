package Tests;
import Pages.BoardsPageHelper;
import Pages.HomePageHelper;
import Pages.LoginPageHelper;
import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    HomePageHelper homePage;
    @BeforeMethod
      public void initTests(){
        loginPage= PageFactory.initElements(driver,LoginPageHelper.class);
        boardsPage= PageFactory.initElements(driver,BoardsPageHelper.class);
        homePage=PageFactory.initElements(driver,HomePageHelper.class);

        homePage.waitUntilHomePageLoaded().openLoginPage();
        loginPage.waitUntilLoginPageIsLoaded();
    }
    @Test
    public void loginEmptyNegativeTest() {
        //enterEmptyLoginAndPassword(PASSWORD);
        loginPage.loginNotAtlassian("",PASSWORD);
        waitUntilElementIsPresent(By.id("error"),10);
        Assert.assertEquals(driver.findElement(By.id("error")).getText(),"Missing email",
                "The text of the error message is not correct");
    }
    @Test
    public void loginNegativeLoginIncorrect()  {
        loginPage.loginNotAtlassian("123",PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessage(),"There isn't an account for this username",
                        "The error message is not 'There isn't an account for this username'");
    }
    @Test
    public void passwordIncorrectNegativeTest() {
        loginPage.loginAsAtlassian(LOGIN,PASSWORD+"1");
        Assert.assertTrue(loginPage.getAtlassianErrorMessage().contains("Incorrect email address and"),
                          "The error message is not contains the text 'Incorrect email address and'");
    }
    @Test
    public void LoginPositive (){
        loginPage.loginAsAtlassian(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        Assert.assertTrue(loginPage.getBoardsIconName().equals("Boards"),"The text on the button is not 'Boards'");

      }
}
