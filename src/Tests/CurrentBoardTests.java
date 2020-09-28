package Tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CurrentBoardTests extends TestBase {
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
        waitUntilElementIsClickable(By.id("'workspaces-preamble-board-header-button"), 10);
        waitUntilElementIsPresent(By.tagName("h1"), 10);
    }

    @Test
    public void isCorrectCurrentBoard() {
        //System.out.println("Header of the current board: "+ driver.findElement(By.tagName("h1")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "QAHaifa7", "The header of the screen is not 'QAHaifa7'");
    }

    //se-07
    @Test
    public void addNewListPositiveTest() {
        //Add new list to the board
        int quantityListsInTheBeginning = driver
                .findElements(By.xpath("//div[@class = 'list js-list-content']"))
                .size();
        waitUntilElementIsClickable((By.xpath("//span[@class='placeholder']")),10);
        WebElement AddNewListButton = driver.findElement(By.xpath("//span[@class='placeholder']"));
        AddNewListButton.click();
        waitUntilElementIsClickable(By.xpath("//input[@class='list-name-input']"), 10);
        //Fill the new list name
        WebElement newListNameField = driver.findElement(By.xpath("//input[@class='list-name-input']"));
        newListNameField.click();
        newListNameField.clear();
        newListNameField.sendKeys("Test");
        waitUntilElementIsClickable(By.xpath("//input[@class='primary mod-list-add-button js-save-edit']"), 10);
        //Save new List
        WebElement saveListButton = driver.findElement(By.xpath("//input[@class='primary mod-list-add-button js-save-edit']"));
        saveListButton.click();
        //Close adding new list
        waitUntilElementIsClickable(By.cssSelector("a.icon-close.dark-hover"), 5);
        WebElement xButton = driver.findElement(By.cssSelector("a.icon-close.dark-hover"));
        xButton.click();
        waitUntilElementIsInvisible(By.cssSelector("a.icon-close.dark-hover"), 5);
        int quantityListsAtTheEnd= driver.findElements(By.xpath("//div[@class = 'list js-list-content']")).size();
        Assert.assertEquals(quantityListsAtTheEnd, quantityListsInTheBeginning +1, "The quantityListsAtTheEnd is not quantityListsInTheBeginning-1 ");
    }

    @Test
    public void putAnyListToArchive() {
        //If there are no lists create the new list
        WebElement addListButton = driver.findElement(By.cssSelector("a.open-add-list"));
        System.out.println("Text on the button: " + addListButton.getText());
        if (addListButton.getText().equals("Add a list")) {
            addListButton.click();
            waitUntilElementIsClickable(By.xpath("//input[@type='submit']"), 5);
            //Fill the name of new list and submit it
            WebElement newListNameField = driver.findElement(By.xpath("//input[@class='list-name-input']"));
            newListNameField.click();
            newListNameField.clear();
            newListNameField.sendKeys("Test");
            //Save new List
            WebElement submitNewList = driver.findElement(By.xpath("//input[@type='submit']"));
            submitNewList.click();
            waitUntilElementIsClickable(By.cssSelector("a.icon-close.dark-hover"), 5);
            WebElement xButton = driver.findElement(By.cssSelector("a.icon-close.dark-hover"));
            xButton.click();
            waitUntilElementIsInvisible(By.cssSelector("a.icon-close.dark-hover"), 5);
        }
        waitUntilElementsAreVisible(By.xpath("//div[@class = 'list js-list-content']"), 15);
        // the quantity of lists in the beginning
        /*System.out.println("Lists quantity after adding the new list: " + driver
                .findElements(By.xpath("//div[@class = 'list js-list-content']"))
                .size());*/
        int quantityListsInTheBeginning = driver
                .findElements(By.xpath("//div[@class = 'list js-list-content']"))
                .size();
        addListButton = driver.findElement(By.cssSelector("a.open-add-list"));
        System.out.println("Text on the button: " + addListButton.getText());
        //open list menu
        WebElement listMenu = driver.findElement(By.cssSelector("a.list-header-extras-menu"));
        listMenu.click();
        waitUntilElementIsClickable(By.xpath("//a[@class='js-close-list']"), 10);
        //delete list
        WebElement closeButton = driver.findElement(By.xpath("//a[@class='js-close-list']"));
        closeButton.click();
        //Print the quantity of lists
        waitUntilElementIsInvisible(By.xpath("//a[@class='js-close-list']"), 10);
        int quantityListsAtTheEnd = driver
                .findElements(By.xpath("//div[@class = 'list js-list-content']"))
                .size();
        System.out.println("lists quantity after delete: " + driver.findElements(By.xpath("//div[@class='list js-list-content']")).size());
        Assert.assertEquals(quantityListsAtTheEnd, quantityListsInTheBeginning - 1, "The quantityListsAtTheEnd is not quantityListsInTheBeginning-1 ");
    }
}