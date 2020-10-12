package Pages;

import Pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageHelper extends PageBase {
    @FindBy(xpath = "//*[@class='btn btn-sm btn-link text-white']")
    WebElement loginIcon;

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }
    public void waitUntilHomePageLoaded() {
        waitUntilElementIsClickable(loginIcon,30);
    }
    public void openLoginPage(){
        loginIcon.click();
    }

}
