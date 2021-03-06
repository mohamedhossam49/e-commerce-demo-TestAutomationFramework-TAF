package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchPage extends PageBase{

    public SearchPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 50);
    }
    @FindBy(id = "small-searchterms")
    WebElement searchField;
    @FindBy(css = "#small-search-box-form > input.button-1.search-box-button")
    WebElement searchButton;
    @FindBy(id = "ui-id-1")
    List<WebElement> autoCompleteListMenu;

    public void searchProductUsingSearchButton(String searchItem){
        wait.until(ExpectedConditions.visibilityOf(searchField));
        EnterText(searchField,searchItem);
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        clickButton(searchButton);
        //Thread.sleep(3000);
    }
    public void searchProductUsingAutoSuggestMenu(String searchItem) {
        wait.until(ExpectedConditions.visibilityOf(searchField));
        EnterText(searchField,searchItem);
        wait.until(ExpectedConditions.visibilityOfAllElements(autoCompleteListMenu));
        autoCompleteListMenu.get(0).click();
       //Thread.sleep(3000);
    }

}
