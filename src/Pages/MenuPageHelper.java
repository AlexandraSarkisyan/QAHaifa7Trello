package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPageHelper extends PageBase{
    @FindBy(xpath = "//a[@data-test-id = 'header-member-menu-profile']")
    WebElement profileVisibilityButton;
    @FindBy(xpath = "//a[@href='/alexandrasark/activity']")
    WebElement activityButton;

    public MenuPageHelper(WebDriver driver) {
        super(driver);

    }
    public MenuPageHelper waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(profileVisibilityButton,20);
        return this;
    }

    public void openProfileVisibility() {
        profileVisibilityButton.click();
    }
    public void openActivity(){
        waitUntilElementIsClickable(activityButton,20);
        activityButton.click();
    }
}
