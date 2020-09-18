package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public static final String LOGIN ="alexandra13sark@gmail.com" ;
    public static final String PASSWORD = "alex613e";
    WebDriver driver;

    @BeforeMethod
    public void startApp() throws InterruptedException {
        //language options rus /eng!
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=" + "rus");*/
        driver = new ChromeDriver(/*options*/);
        driver.get("https://trello.com/");
        Thread.sleep(10000);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
