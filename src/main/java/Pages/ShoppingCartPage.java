package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ShoppingCartPage extends PageBase {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 30);
    }
    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    public WebElement productName;

    @FindBy(tagName = "tr")
    WebElement productDetailsField;

    @FindBy(tagName = "td")
    List<WebElement> allColsDetails;

    @FindBy(name = "removefromcart")
    WebElement removeProductButton;

    @FindBy(name = "updatecart")
    WebElement updateCartButton;

    @FindBy(className = "no-data")
    public WebElement emptyCartSuccessMessage;

    @FindBy(className = "qty-input")
    WebElement updateQuantityField;

    @FindBy (id = "checkout")
    WebElement checkoutButton;

    @FindBy(id = "termsofservice")
    WebElement termsOfServiceButton;

    public void printProductDetails() {
        System.out.println(productDetailsField.getText());
        for (WebElement col:allColsDetails) {
            System.out.println(col.getText()+"\t");
        }
    }

    public void updateProductQuantity(String quantity){
        updateQuantityField.clear();
        EnterText(updateQuantityField,quantity);
        clickButton(updateCartButton);
    }

    public void removeProductFromCart(){
        clickButton(removeProductButton);
        clickButton(updateCartButton);
    }
    public void openCheckoutPage() {
        clickButton(termsOfServiceButton);
        clickButton(checkoutButton);
        //Thread.sleep(3000);
    }
}
