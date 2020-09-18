package Tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
      public void initTests() throws InterruptedException {
        WebElement logInIcon = driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']"));
        logInIcon.click();
        Thread.sleep(10000);
    }
    @Test
    public void loginNegativeTest() throws InterruptedException {
        //Enter empty login and password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("alex613e");
        Thread.sleep(10000);
        WebElement login = driver.findElement(By.id("login"));
        login.click();
        Thread.sleep(10000);
        WebElement errorEmail = driver.findElement(By.xpath("//p[contains(text(),'Missing email')]"));
        System.out.println("Exception: "+  errorEmail.getText());
    }
    //se-04
    @Test
    public void passwordLoginNegativeTest() throws InterruptedException {
        // Enter not existent login
        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys("summer.gmail.com");
        //Enter existent password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(PASSWORD);
        Thread.sleep(10000);
        //Press login button
        WebElement login = driver.findElement(By.id("login"));
        login.click();
        Thread.sleep(10000);
        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='error']//p[@class='error-message']"));
        System.out.println("Exception: "+  errorMessage.getText());
    }
    //se-05
    @Test
    public void passwordNegativeTest() throws InterruptedException {
        // Enter login field for attlassian
        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(LOGIN);
        //Submit login attlassian
        WebElement login = driver.findElement(By.id("login"));
        login.click();
        Thread.sleep(10000);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(PASSWORD+"1");
        Thread.sleep(10000);
        WebElement loginButton = driver.findElement(By.id("login-submit"));
        loginButton.click();
        Thread.sleep(10000);
        WebElement errorMessage = driver.findElement(By.xpath("//div[@role='alert'][@id='login-error']"));
        System.out.println("Exception: "+  errorMessage.getText());
    }

    @Test
    public void LoginPositiveTestClasswork() throws InterruptedException {
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
        //Submit
        WebElement loginSubmit = driver.findElement(By.id("login-submit"));
        loginSubmit.click();
        Thread.sleep(65000);
        //Check our entry
        WebElement boardsButton = driver.findElement(By.xpath("//button[@data-test-id = 'header-boards-menu-button']"));
        System.out.println("Button name: "+ boardsButton.getText());
      }

}
