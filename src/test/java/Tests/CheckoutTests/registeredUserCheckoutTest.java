package Tests.CheckoutTests;

import Pages.*;
import Tests.TestBases.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class registeredUserCheckoutTest extends TestBase {
    SearchPage searchObj;
    ProductDetailsPage productDetailsObj;
    ShoppingCartPage shoppingCartObj;
    CheckoutPage checkoutObj;
    UserRegistrationPage userRegisterObj;
    OrderDetailsPage orderDetailsObj;
    String firstName = "Mohamed";
    String lastName = "Hossam";
    String email = "demo@125.com";
    String password = "123456";
    @Test
    public void testUserCanSearchForProduct() {
        searchObj = new SearchPage(driver);
        searchObj.searchProductUsingAutoSuggestMenu("Mac");
        //Thread.sleep(3000);
    }
    @Test(dependsOnMethods = {"testUserCanSearchForProduct"})
    public void testUserCanAddproductToCart() {
        productDetailsObj = new ProductDetailsPage(driver);
        productDetailsObj.addProductToCart();
        productDetailsObj.openCartPage();
        //Thread.sleep(6000);
    }
    @Test(dependsOnMethods = {"testUserCanAddproductToCart"})
    public void tesUserCanRegisterToCheckout() {
        shoppingCartObj = new ShoppingCartPage(driver);
        checkoutObj = new CheckoutPage(driver);
        shoppingCartObj.openCheckoutPage();
        checkoutObj.openUserRegisterPage();
        checkoutObj.newUserRegisteration(firstName,lastName,email,password);
        Assert.assertTrue(checkoutObj.registrationSuccessMessage.getText()
                .contains("registration completed"));
    }
    @Test(dependsOnMethods = {"tesUserCanRegisterToCheckout"})
    public void testUserCanCheckout()  {
        shoppingCartObj = new ShoppingCartPage(driver);
        checkoutObj= new CheckoutPage(driver);
        checkoutObj.continueToCheckout();
        shoppingCartObj.openCheckoutPage();
        checkoutObj.checkOutByMoneyOrder("Algeria","shd","5thditrs"
                ,"12566","01131131");
        Assert.assertTrue(checkoutObj.productNameFieldInConfirmPage.getText()
        .contains("Apple MacBook Pro 13-inch"));
        checkoutObj.confirmOrder();
        Assert.assertTrue(checkoutObj.orderSuccessConfirmMessage.getText()
        .contains("Your order has been successfully processed!"));
    }
    @Test(dependsOnMethods = {"testUserCanCheckout"})
    public void testUserCanPrintOrderDetails() {
        checkoutObj = new CheckoutPage(driver);
        checkoutObj.openOrderDetailsPage();
        orderDetailsObj = new OrderDetailsPage(driver);
        orderDetailsObj.printOrderDetails();
    }
    @Test(dependsOnMethods = {"testUserCanPrintOrderDetails"})
    public void testUserCanLogoutAfterCheckout(){
        userRegisterObj = new UserRegistrationPage(driver);
        userRegisterObj.RegisteredUserLogout();
    }

}
