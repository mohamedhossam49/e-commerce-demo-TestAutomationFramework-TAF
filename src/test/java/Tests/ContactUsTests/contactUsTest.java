package Tests.ContactUsTests;

import Pages.ContactUsPage;
import Pages.HomePage;
import Tests.TestBases.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class contactUsTest extends TestBase {
    String name = "Mohamed Hossam";
    String email = "test@124.com";
    String enquiry = "This is a testing session";
    HomePage homeObj;
    ContactUsPage contactUsObj;
    @Test
    public void testContactUs() {
            homeObj = new HomePage(driver);
            contactUsObj = new ContactUsPage(driver);
            homeObj.openContactUsPage();
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            contactUsObj.sendAnEnquiry(name, email, enquiry);
            Assert.assertTrue(contactUsObj.enquirySentsuccessMessage.getText()
                    .contains("enquiry has been successfully sent"));
    }
}
