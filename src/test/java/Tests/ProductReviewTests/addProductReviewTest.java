package Tests.ProductReviewTests;


import Pages.*;
import Tests.TestBases.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class addProductReviewTest extends TestBase {
    HomePage homeObj;
    UserRegistrationPage registerObj;
    SearchPage searchObj;
    ProductDetailsPage productDetailsObj;
    AddProductReviewPage addProductReviewObj;
    @Test
    public void testUserCanRegisterSuccessfully()  {
        homeObj = new HomePage(driver);
        registerObj = new UserRegistrationPage(driver);
        homeObj.openRegistrationPage();
        //Thread.sleep(3000);
        registerObj.userRegistration("a", "b",
                "demo98@test.com", "1234566", "24",
                "December", "53");
    }
    @Test(dependsOnMethods = {"testUserCanRegisterSuccessfully"})
    public void testUserCanSearchProductUsingAutoComplete()  {
        searchObj = new SearchPage(driver);
        //Thread.sleep(3000);
        searchObj.searchProductUsingAutoSuggestMenu("Mac");
    }
    @Test(dependsOnMethods = {"testUserCanSearchProductUsingAutoComplete"})
    public void userCanAddProductReview()  {
        productDetailsObj = new ProductDetailsPage(driver);
        addProductReviewObj = new AddProductReviewPage(driver);
        //Thread.sleep(3000);
        productDetailsObj.openAddProductReviewPage();
        addProductReviewObj.addProductReviewWithRating3("Test Review","" +
                "We are testing the review product Functionality");
        //Thread.sleep(3000);
        Assert.assertTrue(addProductReviewObj.reviewNotificationMessage.getText()
            .contains("review is successfully added"));

    }
}


