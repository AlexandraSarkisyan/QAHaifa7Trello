package Tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
      public void initTests(){
        WebElement logInIcon = driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']"));
        logInIcon.click();
        waitUntilElementIsClickable(By.id("password"),10);
    }
 @Test
    public void loginNegativeTest() {
        //Enter empty login and password
        //wait method
        waitUntilElementIsClickable(By.id("password"),10);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("alex613e");
        //wait method
        waitUntilElementIsClickable(By.id("login"),10);
        //press login button
        WebElement login = driver.findElement(By.id("login"));
        login.click();
        //wait method
        waitUntilElementIsPresent(By.id("error"),10);
        /*WebElement errorEmail = driver.findElement(By.xpath("//p[contains(text(),'Missing email')]"));
        System.out.println("Exception: "+  errorEmail.getText());*/
        Assert.assertEquals(driver.findElement(By.id("error")).getText(),"Missing email",
                "The text of the error message is not correct");
    }
    //se-04
    @Test
    public void passwordLoginNegativeTest() throws InterruptedException {
        // Enter not existent login
        waitUntilElementIsClickable(By.id("user"),10);
        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys("summer.gmail.com");
        //Enter existent password
        waitUntilElementIsClickable(By.id("password"),5);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(PASSWORD);
        //Press login button
        waitUntilElementIsClickable(By.id("login"),10);
        WebElement login = driver.findElement(By.id("login"));
        login.click();
        Thread.sleep(10000);
        waitUntilElementIsPresent(By.xpath("//div[@id='error']//p[@class='error-message']"),10);
        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='error']//p[@class='error-message']"));
        Assert.assertEquals(errorMessage.getText(),"There isn't an account for this username",
                "The text of the error message is not correct");
    }
    //se-05
    @Test
    public void passwordNegativeTest() {
        // Enter login field for attlassian
        waitUntilElementIsClickable(By.id("user"),10);
        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(LOGIN);
        //wait
        waitUntilElementIsClickable(By.xpath("//input[@value='Log in with Atlassian']"),10);
        //Submit login attlassian
        WebElement login = driver.findElement(By.id("login"));
        login.click();
        //wait
        waitUntilElementIsClickable(By.id("password"),10);
        //enter Atlassian password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("alex");
        //wait
        waitUntilElementIsClickable(By.id("login-submit"),10);
        WebElement loginButton = driver.findElement(By.id("login-submit"));
        loginButton.click();
        //wait
        waitUntilElementIsPresent(By.cssSelector("#login-error"),5);
        WebElement errorMessage = driver.findElement(By.cssSelector("#login-error"));
        Assert.assertEquals(errorMessage.getTagName(),"div","The tag Name of the error message is not correct");
    }

    @Test
    public void LoginPositive (){
        //enter login field
        //wait method
        waitUntilElementIsClickable(By.id("user"),10);
        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(LOGIN);
        //wait method
        waitUntilElementIsClickable(By.xpath("//input[@value='Log in with Atlassian']"),10);
        // Submit Atlassian  login field
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        //wait method
        waitUntilElementIsClickable(By.id("password"),10);
        //Enter atlassian password
        WebElement passwordAtlassianField = driver.findElement(By.id("password"));
        passwordAtlassianField.click();
        passwordAtlassianField.clear();
        passwordAtlassianField.sendKeys(PASSWORD);
        //wait method
        waitUntilElementIsClickable(By.id("login-submit"),10);
        //Submit
        WebElement loginSubmit = driver.findElement(By.id("login-submit"));
        loginSubmit.click();
        //wait method
        waitUntilElementIsClickable(By.xpath("//button[@data-test-id = 'header-boards-menu-button']"),15);
        //Check our entry
        WebElement boardsButton = driver.findElement(By.xpath("//button[@data-test-id = 'header-boards-menu-button']"));
        //System.out.println("Button name: "+ boardsButton.getText());
        //Assert.assertEquals(boardsButton.getText(),"Boards","The text on the button is not correct");
        Assert.assertTrue(boardsButton.getText().equals("Boards"),"The text on the button is not 'Boards'");
      }

}
