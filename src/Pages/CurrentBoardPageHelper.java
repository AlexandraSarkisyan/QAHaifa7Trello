package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CurrentBoardPageHelper extends PageBase {
    @FindBy(css = "a.list-header-extras-menu")
    WebElement listMenuButton;

    @FindBy(id = "workspaces-preamble-board-header-button")
    WebElement boardsButton;

    @FindBy(tagName = "h1")
    WebElement header;

    /*@FindBy(xpath = "//div[@class = 'list js-list-content']")
    WebElement lists;*/

    @FindBy(css = "a.open-add-list")
    WebElement addListButton;

    @FindBy(xpath = "//input[@class='list-name-input']")
            WebElement listNameField;
    @FindBy(xpath = "//button[@aria-label = 'Open Member Menu']")
            WebElement memberMenu;
    @FindBy(xpath = "//input[@class='primary mod-list-add-button js-save-edit']")
            WebElement saveNewListButton;
    @FindBy(css = "a.icon-close.dark-hover")
            WebElement closeAddNewListButton;
    @FindBy(xpath = "//a[@class='js-close-list']")
            WebElement putListToArchiveButton;
    @FindBy(xpath = "//span[@class='icon-sm icon-add']")
            WebElement addCardButton;
    @FindBy(xpath = "//textarea[@placeholder='Enter a title for this card…']")
            WebElement cardTitleButton;
    @FindBy(xpath = "//input[@class='primary confirm mod-compact js-add-card']")
            WebElement submitNewCard;
    @FindBy(xpath = "//a[@class='icon-lg icon-close dark-hover js-cancel']")
            WebElement cancelButton;
    String boardName;

    public CurrentBoardPageHelper(WebDriver driver,String boardName) {
        super(driver);
        this.boardName=boardName;
        PageFactory.initElements(driver,this);
    }
    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(boardsButton, 10);
        waitUntilElementIsVisible(header, 10);
    }
    public String getCurrentBoardHeader(){
        return header.getText();
    }

    public boolean isCorrectCurrentBoard() {
        return driver.findElement(By.tagName("h1")).getText().equals(this.boardName);
    }
    public int getQuantityLists() {
        waitUntilElementsAreVisible(By.xpath("//div[@class = 'list js-list-content']"), 15);
        return driver.findElements(By.xpath("//div[@class = 'list js-list-content']")).size();
    }
    public void addNewListToCurrentBoard(String listName) {
        waitUntilElementIsClickable(addListButton,10);
        addListButton.click();
        waitUntilElementIsClickable(listNameField, 10);
        listNameField.click();
        listNameField.clear();
        listNameField.sendKeys(listName);
        saveNewList();
        closeAddingNewList();
    }

    public void saveNewList() {
        waitUntilElementIsClickable(saveNewListButton, 10);
        saveNewListButton.click();
    }

    public void closeAddingNewList() {
        waitUntilElementIsClickable(closeAddNewListButton, 5);
        //close x button
        closeAddNewListButton.click();
        waitUntilElementIsInVisible(closeAddNewListButton, 5);
    }

    public void putListToTheArchive() {
        waitUntilElementIsClickable(putListToArchiveButton, 10);
        putListToArchiveButton.click();
        waitUntilElementIsInVisible(putListToArchiveButton,10);
    }

    public void openListMenu() {
        waitUntilElementIsClickable(listMenuButton,10);
        listMenuButton.click();
    }

    public String getTextAddListButton() {
        return addListButton.getText();
    }

    public void openMemberMenu() {
        waitUntilElementIsClickable(memberMenu,10);
        memberMenu.click();
    }
    public void addACard(String text){
        waitUntilElementIsClickable(addCardButton,10);
        addCardButton.click();
        waitUntilElementIsClickable(cardTitleButton,10);
        cardTitleButton.click();
        cardTitleButton.clear();
        cardTitleButton.sendKeys(text);
        waitUntilElementIsClickable(submitNewCard,10);
        submitNewCard.click();
        waitUntilElementIsClickable(cancelButton,10);
        cancelButton.click();
        waitUntilElementIsInVisible(cancelButton,10);
    }

}
