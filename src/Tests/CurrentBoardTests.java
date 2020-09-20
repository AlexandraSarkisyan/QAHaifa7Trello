package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CurrentBoardTests extends TestBase{
    @BeforeMethod
 public void initTest() throws InterruptedException {
     //open login window
     WebElement logInIcon = driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']"));
     logInIcon.click();
     Thread.sleep(10000);
     //enter login field
     WebElement emailField = driver.findElement(By.id("user"));
     emailField.click();
     emailField.clear();
     emailField.sendKeys(LOGIN);
     Thread.sleep(3000);
     // Submit Atlassian  login field
     WebElement loginButton = driver.findElement(By.id("login"));
     loginButton.click();
     Thread.sleep(10000);
     //Enter atlassian password
     WebElement passwordAtlassianField = driver.findElement(By.id("password"));
     passwordAtlassianField.click();
     passwordAtlassianField.clear();
     passwordAtlassianField.sendKeys(PASSWORD);
     Thread.sleep(20000);
     //Submit password
     WebElement loginSubmit = driver.findElement(By.id("login-submit"));
     loginSubmit.click();
     Thread.sleep(65000);
     //click button boards
     WebElement boardsButton = driver.findElement(By.xpath("//button[@data-test-id = 'header-boards-menu-button']"));
     boardsButton.click();
     //find board in list
     WebElement searchBoardsField = driver.findElement(By.xpath("//input[@name='search-boards']"));
     searchBoardsField.click();
     searchBoardsField.clear();
     searchBoardsField.sendKeys("QAHaifa7");
     Thread.sleep(20000);
     //Open QA7Haifa board
        WebElement boardQAHaifa7 = driver.findElement(By.xpath("//div[contains(text(),'QAHaifa7')]"));
        boardQAHaifa7.click();
        Thread.sleep(5000);

 }
//se-07
    @Test
    public void addNewListPositiveTest() throws InterruptedException {
        System.out.println("lists quantity before : "+driver.findElements(By.xpath("//div[@class='list js-list-content']")).size());
        Thread.sleep(20000);
        //Add new list to the board
        WebElement AddNewListButton = driver.findElement(By.xpath("//span[@class='placeholder']"));
        AddNewListButton.click();
        Thread.sleep(20000);
        //Fill the new list name
        WebElement newListNameField = driver.findElement(By.xpath("//input[@class='list-name-input']"));
        newListNameField.click();
        newListNameField.clear();
        newListNameField.sendKeys("Test");
        Thread.sleep(20000);
        //Save new List
        WebElement saveListButton = driver.findElement(By.xpath("//input[@class='primary mod-list-add-button js-save-edit']"));
        saveListButton.click();
        Thread.sleep(20000);
        System.out.println("lists quantity after : "+driver.findElements(By.xpath("//div[@class='list js-list-content']")).size());
        Thread.sleep(20000);
    }
    @Test
 public void deleteList() throws InterruptedException {
        //If board empty- add new List
     if(driver.findElements(By.xpath("//div[@class='list js-list-content']")).size()<1) {
         WebElement AddNewListButton = driver.findElement(By.xpath("//span[@class='placeholder']"));
         AddNewListButton.click();
         Thread.sleep(20000);
         WebElement newListNameField = driver.findElement(By.xpath("//input[@class='list-name-input']"));
         newListNameField.click();
         newListNameField.clear();
         newListNameField.sendKeys("Test");
         Thread.sleep(20000);
         //Save new List
         WebElement saveListButton = driver.findElement(By.xpath("//input[@class='primary mod-list-add-button js-save-edit']"));
         saveListButton.click();
         Thread.sleep(20000);
     }
        System.out.println("lists quantity before : "+driver.findElements(By.xpath("//div[@class='list js-list-content']")).size());
        Thread.sleep(20000);
        //open list menu
        WebElement listMenu= driver.findElement(By.cssSelector("a.list-header-extras-menu"));
        listMenu.click();
        Thread.sleep(20000);
        //delete list
        WebElement closeButton = driver.findElement(By.xpath("//a[@class='js-close-list']"));
        closeButton.click();
        System.out.println("lists quantity after delete: "+driver.findElements(By.xpath("//div[@class='list js-list-content']")).size());
}
}
