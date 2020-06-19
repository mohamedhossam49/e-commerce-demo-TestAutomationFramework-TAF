package Tests.SearchProductTests;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Tests.TestBases.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductUsingAutoComplete extends TestBase {
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchProductObj;
    ProductDetailsPage productDetailsObj;

    @Test
    public void testSearchUsingAutoComplete() {
        searchProductObj = new SearchPage(driver);
        productDetailsObj = new ProductDetailsPage(driver);
        searchProductObj.searchProductUsingAutoSuggestMenu("Mac");
        Assert.assertEquals(productName, productDetailsObj.searchResultProductName.getText());
    }

}
