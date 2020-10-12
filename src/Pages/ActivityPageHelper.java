package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActivityPageHelper extends PageBase{
    @FindBy(xpath = "//a[@data-tab='activity']")
    WebElement profileTab;
    public ActivityPageHelper(WebDriver driver) {
        super(driver);
    }
    public String getActivityTabName(){
        return profileTab.getText();
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(profileTab,10);
    }
    public String getTitleCardFromEvent(){
        return driver.findElement(By.xpath("//a[contains(text(),'NewCard')]")).getText();

    }

}
