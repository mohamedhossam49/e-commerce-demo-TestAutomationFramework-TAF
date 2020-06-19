package Tests.UserRegistrationTests;

import Pages.HomePage;
import Pages.UserRegistrationPage;
import Tests.TestBases.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRegistrationTest extends TestBase {
    HomePage home;
    UserRegistrationPage userRegister;
    @Test
    public void testUserCanRegisterSuccessfully() {
        home = new HomePage(driver);
        userRegister = new UserRegistrationPage(driver);
        home.openRegistrationPage();
        userRegister.userRegistration("a","b",
                "demo1982@test.com","1234566","24",
                "December","1998");
        Assert.assertTrue(userRegister.registrationSuccessMessage.isDisplayed());
    }
    @Test(dependsOnMethods = {"testUserCanRegisterSuccessfully"})
    public void testRegisteredUserCanLogout(){
        userRegister = new UserRegistrationPage(driver);
        userRegister.RegisteredUserLogout();
    }
}
