package Tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfileAndVisibility extends TestBase{
    @BeforeMethod
    public void initTest() {
        //open login window
        waitUntilElementIsClickable(By.xpath("//a[@class='btn btn-sm btn-link text-white']"),10);
        WebElement logInIcon = driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']"));
        logInIcon.click();
        waitUntilElementIsClickable(By.id("user"), 10);
        //enter login field
        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(LOGIN);
        waitUntilElementIsClickable(By.xpath("//input[@value='Log in with Atlassian']"), 10);
        // Submit Atlassian  login field
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        waitUntilElementIsClickable(By.id("password"), 10);
        //Enter atlassian password
        WebElement passwordAtlassianField = driver.findElement(By.id("password"));
        passwordAtlassianField.click();
        passwordAtlassianField.clear();
        passwordAtlassianField.sendKeys(PASSWORD);
        //Submit password
        waitUntilElementIsClickable(By.id("login-submit"), 10);
        WebElement loginSubmit = driver.findElement(By.id("login-submit"));
        loginSubmit.click();
        waitUntilElementIsClickable(By.xpath("//button[@data-test-id = 'header-boards-menu-button']"), 45);
        //click button boards
        WebElement boardsButton = driver.findElement(By.xpath("//button[@data-test-id = 'header-boards-menu-button']"));
        boardsButton.click();
        //find board in list
        WebElement searchBoardsField = driver.findElement(By.xpath("//input[@name='search-boards']"));
        searchBoardsField.click();
        searchBoardsField.clear();
        searchBoardsField.sendKeys("QAHaifa7");
        //Open QA7Haifa board
        waitUntilElementIsClickable(By.xpath("//div[contains(text(),'QAHaifa7')]"), 10);
        WebElement boardQAHaifa7 = driver.findElement(By.xpath("//div[contains(text(),'QAHaifa7')]"));
        boardQAHaifa7.click();
        waitUntilElementIsClickable(By.id("'workspaces-preamble-board-header-button"), 5);
        waitUntilElementIsPresent(By.tagName("h1"), 10);
        waitUntilElementIsClickable(By.xpath("//div[@class='_1FekJJAz6Hu32v']"),5);
        //open account menu
        WebElement menu = driver.findElement(By.xpath("//div[@class='_1FekJJAz6Hu32v']"));
        menu.click();
        //click button profile and visibility
        waitUntilElementIsClickable(By.xpath("//a[@data-test-id='header-member-menu-profile']"),5);
        WebElement profileAndVisibility = driver.findElement(By.xpath("//a[@data-test-id='header-member-menu-profile']"));
        //open page
        profileAndVisibility.click();
        waitUntilElementIsClickable(By.xpath("//a[@data-tab='settings']"),10);
    }
    @Test
    public void userNameTest(){
        waitUntilElementIsClickable(By.xpath("//button[@aria-label='Open Member Menu']"),10);
        WebElement memberMenu = driver.findElement(By.xpath("//button[@aria-label='Open Member Menu']"));
        waitUntilElementIsClickable(By.xpath("//input[@name='username']"),10);
        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
        Assert.assertEquals(memberMenu.getAttribute("title"),usernameField.getAttribute("value"),"Username is not correct");
    }
}
