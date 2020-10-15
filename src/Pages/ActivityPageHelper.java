package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActivityPageHelper extends PageBase{
    @FindBy(xpath = "//a[@data-tab='activity']")
    WebElement profileTab;
    @FindBy(xpath = "//button[@data-test-id='header-boards-menu-button']")
    WebElement boardsButton;
    public ActivityPageHelper(WebDriver driver) {
        super(driver);
    }
    public String getActivityTabName(){
        return profileTab.getText();
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(profileTab,30);
        waitUntilElementIsClickable(boardsButton,30);
    }
    public String getTitleCardFromEvent(){
        return driver.findElement(By.xpath("//a[@class='action-card']")).getText();

    }
    public void backToCurrentBoard(){
        driver.navigate().back();
    }

}
