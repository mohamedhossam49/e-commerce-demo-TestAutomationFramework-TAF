package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageBase {
    protected static WebDriver driver;
    public JavascriptExecutor jse;
    public Select select;
    public Actions action;
    public WebDriverWait wait;

    //CONSTRUCTOR
    public PageBase(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //Main Functions used in all page objects
    public void clickButton(WebElement Button) {
        wait.until(ExpectedConditions.visibilityOf(Button));
        Button.click();
    }

    public void EnterText(WebElement textField, String text) {
        wait.until(ExpectedConditions.visibilityOf(textField));
        textField.sendKeys(text);
    }

    public void scrollToBottom() {
        jse.executeScript("scrollBy(0,2500)");
    }
}
    /*
    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = driver1 -> Objects.equals(((JavascriptExecutor) driver1)
                .executeScript("return document.readyState"), "complete");
        wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);

            protected void waitForElementToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                }

    protected void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
                }

*/