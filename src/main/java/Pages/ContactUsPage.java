package Pages;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.IDN;
import java.util.concurrent.TimeUnit;

public class ContactUsPage extends PageBase {
    public ContactUsPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 30);
    }
    public JavascriptException jse;

    @FindBy(id = "FullName")
    WebElement yourNameField;

    @FindBy(id = "Email")
    WebElement emailField;

    @FindBy(css = "#Enquiry")
    WebElement enquiryField;

    @FindBy(css = "body > div.master-wrapper-page > div.master-wrapper-content > " +
            "div > div > div > div.page-body > form > div.buttons > input")
    WebElement submitButton;

    @FindBy(css = "body > div.master-wrapper-page > " +
            "div.master-wrapper-content > div > div > div > div.page-body > div.result")
    public WebElement enquirySentsuccessMessage;

    public void sendAnEnquiry(String Name, String email, String Enquiry) {
        //Thread.sleep(3000);
        EnterText(yourNameField,Name);
        EnterText(emailField,email);
        EnterText(enquiryField,Enquiry);

        clickButton(submitButton);
        //Thread.sleep(3000);
    }


}
