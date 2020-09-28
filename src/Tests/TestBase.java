package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public static final String LOGIN ="alexandra13sark@gmail.com" ;
    public static final String PASSWORD = "alex613e";
    WebDriver driver;

    @BeforeMethod
    public void startApp(){
        //language options rus /eng!
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=" + "rus");*/
        driver = new ChromeDriver(/*options*/);
        driver.get("https://trello.com/");
        waitUntilElementIsPresent(By.xpath("//a[@class='btn btn-sm btn-link text-white']"),10);
    }
    public void waitUntilElementIsClickable(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void waitUntilElementIsPresent(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void waitUntilElementIsInvisible(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void waitUntilElementsAreVisible(By locator, int time){
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
