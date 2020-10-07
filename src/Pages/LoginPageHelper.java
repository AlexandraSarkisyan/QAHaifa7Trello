package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageHelper extends PageBase{
    public LoginPageHelper(WebDriver driver){
        super(driver);
        this.driver= driver;
    }
    public void loginAsAtlassian(String login,String password) {
        enterLoginAsAtlassian(login);
        submitAsAtlassian();
        enterPasswordAsAtlassian(password);
    }
    public String getBoardsIconName(){
        return driver.findElement(By.xpath("//button[@data-test-id = 'header-boards-menu-button']")).getText();
    }
    public void enterPasswordAsAtlassian(String password) {
        //enter Atlassian password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
        waitUntilElementIsClickable(By.id("login-submit"),10);
        WebElement loginButton = driver.findElement(By.id("login-submit"));
        loginButton.click();
    }
    public void loginNotAtlassian(String login,String password) {
        enterNotAttlassianLogin(login);
        enterNotAttlassianPassword(password);
        pressLoginButton();
    }
    public void submitAsAtlassian() {
        waitUntilElementIsClickable(By.xpath("//input[@value='Log in with Atlassian']"),10);
        WebElement login = driver.findElement(By.id("login"));
        login.click();
        waitUntilElementIsClickable(By.id("password"),10);
    }

    public void enterLoginAsAtlassian(String login) {
        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(login);
    }

    public void waitUntilLoginPageIsLoaded(){
        // waitUntilElementIsClickable(By.id("password"),10);
        waitUntilElementIsClickable(By.id("login"),10);
        // waitUntilElementIsClickable(By.id("user"),10);
    }
    public String getErrorMessage(){
        waitUntilElementIsVisible(By.id("error"), 10);
        return driver.findElement(By.id("error")).getText();
    }

    public String getAtlassianErrorMessage(){
        waitUntilElementIsVisible(By.id("login-error"), 10);
        return driver.findElement(By.id("login-error")).getText();
    }
    public void enterNotAttlassianLogin(String login) {
        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(login);
    }
    public void enterNotAttlassianPassword(String password) {
        //Enter existent password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void pressLoginButton() {
        //Press login button
        waitUntilElementIsClickable(By.id("login"),10);
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
    }

}
