package Tests.ProductsCompareTests;

import Pages.ProductComparePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Tests.TestBases.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class productCompareTest extends TestBase {
    SearchPage searchObj;
    ProductDetailsPage productDetailsObj;
    ProductComparePage productCompareObj;
    String firstProductName = "Mac";
    String secondProductName = "Asus";
    @Test
    public void UserCanAddProductsToCompare() {
        searchObj = new SearchPage(driver);
        productDetailsObj = new ProductDetailsPage(driver);
        productCompareObj = new ProductComparePage(driver);
        searchObj.searchProductUsingAutoSuggestMenu(firstProductName);
        //Thread.sleep(3000);
        productDetailsObj.addProductToCompare();
        searchObj.searchProductUsingAutoSuggestMenu(secondProductName);
       // Thread.sleep(3000);
        productDetailsObj.addProductToCompare();
        productDetailsObj.openProductComparisonPage();
        //Thread.sleep(3000);
        productCompareObj.printProductsData();
        Assert.assertTrue(productCompareObj.firstProductName.getText()
                .contains(firstProductName));
        Assert.assertTrue(productCompareObj.secondProductName.getText()
        .contains(secondProductName));
        Assert.assertEquals(8,productCompareObj.allRowsFields.size());
    }
    @Test(dependsOnMethods = {"UserCanAddProductsToCompare"})
    public void testUserCanClearComparePage(){
        productCompareObj = new ProductComparePage(driver);
        //Thread.sleep(4000);
        productCompareObj.clearComparePage();
        Assert.assertTrue(productCompareObj.removeProductsSucessMessage.getText()
                .contains("no items to compare."));
    }
}
