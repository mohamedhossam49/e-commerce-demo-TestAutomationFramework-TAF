package Tests.ChangeCurrencyTests;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Tests.TestBases.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class changeCurrencyTest extends TestBase {
    HomePage homeObj;
    SearchPage searchObj;
    ProductDetailsPage productDetailsObj;
    @Test
    public void testUserCanChangeCurrencyToEuro() {
    homeObj = new HomePage(driver);
    searchObj = new SearchPage(driver);
    productDetailsObj = new ProductDetailsPage(driver);
    homeObj.selectEuroFromDropDownCurrencyMenu();
    searchObj.searchProductUsingAutoSuggestMenu("Mac");
    Assert.assertTrue(productDetailsObj.productPriceValue.getText().contains("Ђ"));
    }

}
