package Pages;

import Pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageHelper extends PageBase {

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }
    public void waitUntilHomePageLoaded() {
        waitUntilElementIsClickable(By.xpath("//a[@class='btn btn-sm btn-link text-white']"),30);
    }
    public void openLoginPage(){
        WebElement logInIcon = driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']"));
        logInIcon.click();
    }

}
