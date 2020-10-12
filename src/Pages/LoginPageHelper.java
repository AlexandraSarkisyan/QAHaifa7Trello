package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageHelper extends PageBase{
    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(id = "user")
    WebElement loginField;

    @FindBy(id = "error")
    WebElement errorMessage;

    @FindBy(id = "login-error")
    WebElement errorMessageAtl;

    @FindBy(xpath = "//input[@value='Log in with Atlassian']")
    WebElement loginButtonAtl;

    @FindBy(id = "login-submit")
    WebElement loginSubmitButton;
    public LoginPageHelper(WebDriver driver){
        super(driver);
        this.driver= driver;
    }
    public void loginAsAtlassian(String login,String password) {
        enterLogin(login);
        submitAsAtlassian();
        enterPasswordAsAtlassian(password);
    }
    public String getBoardsIconName(){
        return driver.findElement(By.xpath("//button[@data-test-id = 'header-boards-menu-button']")).getText();
    }
    public void enterPasswordAsAtlassian(String password) {
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
        waitUntilElementIsClickable(loginSubmitButton,10);
        loginSubmitButton.click();
    }
    public void loginNotAtlassian(String login,String password) {
        //Enter not atl login
        enterLogin(login);
        enterNotAttlassianPassword(password);
        pressLoginButton();
    }
    public void submitAsAtlassian() {
        waitUntilElementIsClickable(loginButtonAtl,10);
        loginButtonAtl.click();
        waitUntilElementIsClickable(passwordField,10);
    }

    public void enterLogin(String login) {
        loginField.click();
        loginField.clear();
        loginField.sendKeys(login);
    }

    public void waitUntilLoginPageIsLoaded(){
       waitUntilElementIsClickable(loginField,10);
    }
    public String getErrorMessage(){
        waitUntilElementIsVisible(errorMessage, 10);
        return errorMessage.getText();
    }

    public String getAtlassianErrorMessage(){
        waitUntilElementIsVisible(errorMessageAtl, 10);
        return errorMessageAtl.getText();
    }
    public void enterNotAttlassianPassword(String password) {
        //Enter existent password
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void pressLoginButton() {
        //Press login button
        waitUntilElementIsClickable(loginButton,10);
        loginButton.click();
    }

}
