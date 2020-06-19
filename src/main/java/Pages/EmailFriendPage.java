package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailFriendPage extends PageBase {

    public EmailFriendPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 30);
    }
    @FindBy(id = "FriendEmail")
    WebElement friendEmailField;

    @FindBy(id="YourEmailAddress")
    WebElement yourEmailField;

    @FindBy(id = "PersonalMessage")
    WebElement personalMessageField;

    @FindBy(css = "body > div.master-wrapper-page > div.master-wrapper-content > div > div > div > div.page-body > form > div.buttons > input")
    WebElement sendEmailButton;

    @FindBy(css="body > div.master-wrapper-page > " +
            "div.master-wrapper-content > div > div > div > div.page-body > div.result")
    public WebElement emailFriendSuccessMessage;

    public void emailProductToFriend(String friendEmail, String personalMessage)  {
        EnterText(friendEmailField,friendEmail);
        //Thread.sleep(1000);
        EnterText(personalMessageField,personalMessage);
        //Thread.sleep(1000);
        clickButton(sendEmailButton);
    }
}
