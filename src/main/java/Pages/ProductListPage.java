package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ProductListPage extends PageBase{

    public ProductListPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 30);
    }
    @FindBy(css = "body > div.master-wrapper-page > div.master-wrapper-content > div > div.center-2 > div > div.page-body > div.search-results > div > div > div > div > div.picture > a")
    WebElement productInProductListPage;

    public void openProductDetailsPage() {
        clickButton(productInProductListPage);
       // Thread.sleep(3000);
    }
}

