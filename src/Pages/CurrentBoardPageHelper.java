package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CurrentBoardPageHelper extends PageBase {
    String boardName;
    public CurrentBoardPageHelper(WebDriver driver,String boardName) {
        super(driver);
        this.driver= driver;
        this.boardName=boardName;
    }
    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(By.id("'workspaces-preamble-board-header-button"), 10);
        waitUntilElementIsPresent(By.tagName("h1"), 10);
    }
    public String getCurrentBoardHeader(){
        return driver.findElement(By.tagName("h1")).getText();
    }
    public boolean isCorrectCurrentBoard() {
        return driver.findElement(By.tagName("h1")).getText().equals(this.boardName);
    }
    public int getQuantityLists() {
        waitUntilElementsAreVisible(By.xpath("//div[@class = 'list js-list-content']"), 15);
        return driver.findElements(By.xpath("//div[@class = 'list js-list-content']")).size();
    }
    public void addNewListToCurrentBoard(String listName) {
        waitUntilElementIsClickable((By.xpath("//span[@class='placeholder']")),10);
        WebElement AddNewListButton = driver.findElement(By.xpath("//span[@class='placeholder']"));
        AddNewListButton.click();
        waitUntilElementIsClickable(By.xpath("//input[@class='list-name-input']"), 10);
        WebElement newListNameField = driver.findElement(By.xpath("//input[@class='list-name-input']"));
        newListNameField.click();
        newListNameField.clear();
        newListNameField.sendKeys(listName);
        saveNewList();
        closeAddingNewList();
    }

    public void saveNewList() {
        waitUntilElementIsClickable(By.xpath("//input[@class='primary mod-list-add-button js-save-edit']"), 10);
        WebElement saveListButton = driver.findElement(By.xpath("//input[@class='primary mod-list-add-button js-save-edit']"));
        saveListButton.click();
    }

    public void closeAddingNewList() {
        waitUntilElementIsClickable(By.cssSelector("a.icon-close.dark-hover"), 5);
        WebElement xButton = driver.findElement(By.cssSelector("a.icon-close.dark-hover"));
        xButton.click();
        waitUntilElementIsInvisible(By.cssSelector("a.icon-close.dark-hover"), 5);
    }

    public void putListToTheArchive() {
        waitUntilElementIsClickable(By.xpath("//a[@class='js-close-list']"), 10);
        WebElement closeButton = driver.findElement(By.xpath("//a[@class='js-close-list']"));
        closeButton.click();
        waitUntilElementIsInvisible(By.xpath("//a[@class='js-close-list']"), 10);
    }

    public void openListMenu() {
        waitUntilElementIsClickable(By.cssSelector("a.list-header-extras-menu"),10);
        WebElement listMenu = driver.findElement(By.cssSelector("a.list-header-extras-menu"));
        listMenu.click();
    }

    public String getTextAddListButton() {
        WebElement addListButton = driver.findElement(By.cssSelector("a.open-add-list"));
        return addListButton.getText();
    }
    public void openProfileAndVisibilityPage() {
        waitUntilElementIsClickable(By.xpath("//a[@data-test-id='header-member-menu-profile']"),5);
        WebElement profileAndVisibility = driver.findElement(By.xpath("//a[@data-test-id='header-member-menu-profile']"));
        profileAndVisibility.click();
        waitUntilElementIsClickable(By.xpath("//a[@data-tab='settings']"),10);
    }

    public void openMemberMenu() {
        waitUntilElementIsClickable(By.xpath("//button[@aria-label = 'Open Member Menu']"),10);
        driver.findElement(By.xpath("//button[@aria-label = 'Open Member Menu']")).click();
    }
}
