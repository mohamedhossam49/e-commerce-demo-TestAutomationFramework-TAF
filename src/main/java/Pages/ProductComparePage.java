package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductComparePage extends PageBase {
    public ProductComparePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 30);
    }
    @FindBy(tagName = "tr")
    public List<WebElement> allRowsFields;

    @FindBy(tagName = "td")
    public List<WebElement> allColsFields;

    @FindBy(css = "body > div.master-wrapper-page > div.master-wrapper-content > div > div.center-2 > div > div.page-body" +
            " > div > table > tbody > tr.remove-product > td:nth-child(2) > input")
    WebElement removeProductButton;

    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    public WebElement firstProductName;

    @FindBy(linkText = "Asus N551JK-XO076H Laptop")
    public WebElement secondProductName;

    @FindBy(className = "no-data")
    public WebElement removeProductsSucessMessage;

    public void printProductsData(){
        for(WebElement row: allRowsFields){
            System.out.println(row.getText() + "\t");
                for(WebElement cols: allColsFields){
                    System.out.println(cols.getText() + "\t");
            }
        }
    }

    public void clearComparePage(){
        clickButton(removeProductButton);
        clickButton(removeProductButton);
    }

}
