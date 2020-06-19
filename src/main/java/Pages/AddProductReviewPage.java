package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AddProductReviewPage extends PageBase {
    public AddProductReviewPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 30);
    }
    @FindBy(id = "AddProductReview_Title")
    WebElement reviewTitleField;

    @FindBy(id = "AddProductReview_ReviewText")
    WebElement reviewTextField;

    @FindBy(id = "addproductrating_3")
    WebElement addProductRating3Button;

    @FindBy(name = "add-review")
    WebElement submitReviewButton;

    @FindBy(css = "body > div.master-wrapper-page > " +
            "div.master-wrapper-content > div > div > div > div.page-body > div.result")
    public WebElement reviewNotificationMessage;

    public void addProductReviewWithRating3(String reviewTitle, String reviewText) {
        //Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(reviewTitleField));
        EnterText(reviewTitleField,reviewTitle);
        wait.until(ExpectedConditions.visibilityOf(reviewTextField));
        EnterText(reviewTextField,reviewText);
        clickButton(addProductRating3Button);
        clickButton(submitReviewButton);
    }

}
