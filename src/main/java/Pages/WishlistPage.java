package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishlistPage extends PageBase{


    public WishlistPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 30);
    }
    @FindBy(name = "removefromcart")
    WebElement removeProductCheckBox;

    @FindBy(name = "updatecart")
    WebElement updateCartButton;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[3]/span")
    public WebElement productNameInWishList;

    @FindBy(xpath ="/html/body/div[6]/div[3]/div/div/div/div[2]/div")
    public WebElement removeProductFromWishListNotification;

    public void removeProductFromWishlist(){
        clickButton(removeProductCheckBox);
        clickButton(updateCartButton);
        wait.until(ExpectedConditions.visibilityOf(removeProductFromWishListNotification));
    }

}
