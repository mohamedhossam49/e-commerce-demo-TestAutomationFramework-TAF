package Tests.WishListTests;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.WishlistPage;
import Tests.TestBases.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class addToWishlistTest extends TestBase {
SearchPage searchObj;
ProductDetailsPage productDetailsObj;
WishlistPage wishlistObj;
    @Test
    public void userCanSearchForProduct() {
        searchObj = new SearchPage(driver);
        searchObj.searchProductUsingAutoSuggestMenu("Mac");
    }
    @Test(dependsOnMethods = {"userCanSearchForProduct"})
    public void testUserCanAddItemToWishlist() {
        productDetailsObj = new ProductDetailsPage(driver);
        wishlistObj = new WishlistPage(driver);
        productDetailsObj.addProductToWishlist();
        //Thread.sleep(3000);
        productDetailsObj.openWishListPage();
        Assert.assertTrue(wishlistObj.productNameInWishList.getText().contains("AP_MBP_13"));
    }
    @Test(dependsOnMethods = {"testUserCanAddItemToWishlist"})
    public void testUserCanRemoveProductFromWishlist() throws InterruptedException {
        wishlistObj = new WishlistPage(driver);
        Thread.sleep(3000);
        wishlistObj.removeProductFromWishlist();
        Thread.sleep(3000);
        Assert.assertTrue(wishlistObj.removeProductFromWishListNotification.getText()
              .contains("wishlist is empty!"));
    }
}
