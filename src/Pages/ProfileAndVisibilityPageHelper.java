package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfileAndVisibilityPageHelper extends PageBase{
    public ProfileAndVisibilityPageHelper(WebDriver driver) {

        super(driver);
    }
    public String getUsernameOfTitleMenuButton() {
        waitUntilElementIsClickable(By.xpath("//button[@aria-label='Open Member Menu']"),10);
        WebElement memberMenu = driver.findElement(By.xpath("//button[@aria-label='Open Member Menu']"));
        String titleMenu = memberMenu.getAttribute("title");
        return titleMenu.substring(titleMenu.indexOf("(")+1,titleMenu.length()-1);
    }
    public String getUsernameFieldContent() {
        waitUntilElementIsClickable(By.xpath("//input[@name='username']"),10);
        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
        return usernameField.getAttribute("value");
    }
    public String isProfileAndVisibilityPage() {
        return driver.findElement(By.xpath("//a[@data-tab='profile']")).getText();
    }
}
