package Tests.SearchProductTests;

import Pages.ProductDetailsPage;
import Pages.ProductListPage;
import Pages.SearchPage;
import Tests.TestBases.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductTest extends TestBase {
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductListPage productListObject;
    ProductDetailsPage productPageObject;

    @Test
    public void testUserCanSearchBySearchButton()  {
        searchObject = new SearchPage(driver);
        productListObject = new ProductListPage(driver);
        productPageObject = new ProductDetailsPage(driver);
        searchObject.searchProductUsingSearchButton(productName);
        productListObject.openProductDetailsPage();
        Assert.assertEquals(productName,productPageObject.searchResultProductName.getText());
    }
}
