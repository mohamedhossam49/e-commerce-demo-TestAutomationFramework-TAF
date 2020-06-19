package Tests.EmailFriendTests;


import Pages.*;
import Tests.TestBases.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailFriendTest extends TestBase {
    String yourEmail = "demo19@demo.com";
    String friendEmail = "mgey@testl.com";
    String personalMsg = "Hello, have a look on this awesome product";
    HomePage homeObj;
    UserRegistrationPage userRegisterObj;
    SearchPage searchObj;
    ProductListPage productListObj;
    ProductDetailsPage productDetailsObj;
    EmailFriendPage emailFriendObj;
    @Test
    public void testSendEmailToFriend() {
            homeObj = new HomePage(driver);
            userRegisterObj = new UserRegistrationPage(driver);
            searchObj = new SearchPage(driver);
            productListObj = new ProductListPage(driver);
            productDetailsObj = new ProductDetailsPage(driver);
            emailFriendObj = new EmailFriendPage(driver);
            homeObj.openRegistrationPage();
            userRegisterObj.userRegistration("Mohamed","Hossam",
                    yourEmail,"molo56667","24",
                    "December","1998");
            searchObj.searchProductUsingSearchButton("Apple MacBook Pro 13-inch");
            productListObj.openProductDetailsPage();
            productDetailsObj.openEmailFriendPage();
            emailFriendObj.emailProductToFriend(friendEmail,personalMsg);
            Assert.assertTrue(emailFriendObj.emailFriendSuccessMessage.getText().contains("message has been sent"));
        }
}
