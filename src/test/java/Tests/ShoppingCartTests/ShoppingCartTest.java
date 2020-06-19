package Tests.ShoppingCartTests;

import Pages.ShoppingCartPage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Tests.TestBases.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTest extends TestBase {
    SearchPage searchObj;
    ProductDetailsPage productDetailssObj;
    ShoppingCartPage cartObj;
    @Test
    public void testUserCanAddProductToCart() {
        searchObj = new SearchPage(driver);
        productDetailssObj= new ProductDetailsPage(driver);
        cartObj = new ShoppingCartPage(driver);
        searchObj.searchProductUsingAutoSuggestMenu("Mac");
        productDetailssObj.addProductToCart();
        //Thread.sleep(3000);
        Assert.assertTrue(productDetailssObj.addToCartSuccessMessage.getText()
        .contains("The product has been added"));
        productDetailssObj.openCartPage();
        cartObj.printProductDetails();
       // Thread.sleep(3000);
    }
    @Test(dependsOnMethods = {"testUserCanAddProductToCart"})
    public void testUserCanUpdateShoppingCart(){
        cartObj = new ShoppingCartPage(driver);
        cartObj.updateProductQuantity("4");
    }
    @Test(dependsOnMethods = {"testUserCanUpdateShoppingCart"})
    public void testUserCanRemoveProductFromCart() {
        cartObj = new ShoppingCartPage(driver);
        cartObj.removeProductFromCart();
       // Thread.sleep(2000);
        Assert.assertTrue(cartObj.emptyCartSuccessMessage.getText()
                .contains("Shopping Cart is empty"));
    }

}
