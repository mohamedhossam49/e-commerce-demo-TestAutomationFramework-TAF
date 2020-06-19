package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class UserLoginPage extends PageBase{

    public UserLoginPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 30);
    }
    @FindBy(id = "Username")
    WebElement usernameField;

    @FindBy(id = "Password")
    WebElement passwordField;

    @FindBy(css = "body > div.master-wrapper-page > section > div > div > div > div" +
            "> div > div.page-body > div.customer-blocks > div.returning-wrapper.fieldset " +
            "> form > div.form-fields > div.buttons > input")
    WebElement loginButton;

    @FindBy(className = "custom-control-label")
    WebElement RememberMeCheckbox;

    @FindBy(css = "body > div.master-wrapper-page > header > div > " +
            "div.header-links-wrapper > div.header-links > ul > li.inbox > a")
    public WebElement PrivateMessageButton;

public void userLogin(String username, String password){
    EnterText(usernameField,username);
    EnterText(passwordField,password);
    clickButton(RememberMeCheckbox);

    clickButton(loginButton);
}
}
