package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        action = new Actions(driver);
        wait = new WebDriverWait(driver, 30);
    }

    @FindBy(className = "userlink")
    public WebElement UserMenu;

    @FindBy(className = "ico-register")
    WebElement RegisterLink;

    @FindBy(className = "ico-login")
    WebElement LoginButton;

    @FindBy(className = "ico-account")
    WebElement myAccountButton;

    @FindBy(linkText = "Contact us")
    WebElement contactUsPageLink;

    @FindBy(id="customerCurrency")
    WebElement dropDownCurrencyMenu;

    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
    WebElement computersMenu;

    @FindBy(linkText = "Notebooks")
    WebElement notebooksPageLink;


    public void openRegistrationPage(){
        clickButton(RegisterLink);
    }
    public void openLoginPage(){
        clickButton(LoginButton);
    }
    public void openMyAccountPage(){
        clickButton(UserMenu);
        clickButton(myAccountButton);
    }
    public void openContactUsPage(){
        scrollToBottom();
        clickButton(contactUsPageLink);
    }
    public void selectEuroFromDropDownCurrencyMenu(){
        select = new Select(dropDownCurrencyMenu);
        select.selectByVisibleText("Euro");
    }
    public void openNotebooksMenuPage(){
        action.moveToElement(computersMenu)
                .build()
                .perform();
        action.moveToElement(notebooksPageLink)
                .click()
                .build()
                .perform();
    }

}
