package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.html.CSS;
import java.util.concurrent.TimeUnit;

public class ProductDetailsPage extends PageBase{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 40);
    }

    @FindBy(tagName = "h1")
    public WebElement searchResultProductName;

    @FindBy(xpath = "//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[10]/div[3]/input")
    WebElement emailFriendPageLink;

    @FindBy(className = "price-value-4")
    public WebElement productPriceValue;

    @FindBy(linkText = "Add your review")
    WebElement addYourReviewPageLink;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div[2]/div/div/div/form/div[2]/div[1]/div[2]/div[10]/div[1]/input")
    WebElement addToWishlistButton;

    @FindBy(css ="#product-details-form > div:nth-child(2) > " +
            "div.product-essential > div.overview > div.overview-buttons > div.compare-products > input")
    WebElement addToCompareButton;

    @FindBy(linkText = "product comparison")
    WebElement productComparePageLink;

    /*@FindBy(css = "#bar-notification > div > p")
    public WebElement productAddedToWishlistNotification;*/

    @FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[3]/a")
    WebElement wishlistPageLink;

    @FindBy(css = "#add-to-cart-button-4")
    WebElement addToCartButton;

    @FindBy(css = "#bar-notification > div > p")
    public WebElement addToCartSuccessMessage;

    @FindBy(css = "#bar-notification > div > p > a")
    WebElement cartPageLink;

    public void openEmailFriendPage() {
        clickButton(emailFriendPageLink);
        //Thread.sleep(3000);
    }
    public void openAddProductReviewPage(){
        clickButton(addYourReviewPageLink);
    }
    public void addProductToWishlist(){
        wait.until(ExpectedConditions.visibilityOf(addToWishlistButton));
        clickButton(addToWishlistButton);
    }
    public void openWishListPage(){
        clickButton(wishlistPageLink);
    }
    public void addProductToCompare(){

        clickButton(addToCompareButton);
    }
    public void openProductComparisonPage(){

        clickButton(productComparePageLink);
    }
    public void addProductToCart(){

        clickButton(addToCartButton);
    }
    public void openCartPage(){

        clickButton(cartPageLink);
    }



}

