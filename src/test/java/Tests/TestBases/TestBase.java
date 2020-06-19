package Tests.TestBases;

import Utilities.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    @BeforeSuite
    public void setUpEnvironmentForTestSuite(){
        String chromePath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
    }

    @BeforeClass
    public void setupEnvironmentBeforeRunningTestCase() {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @AfterClass
    public void prepareForTheNextTestCase() throws InterruptedException {
        driver.quit();
        Thread.sleep(2000);
    }


    @AfterSuite
    public void quitDriver(){
        driver.quit();
    }


    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot");
            Helper.captureScreenshot(driver, result.getName());
        }
    }
}
//taking screenshot on failure and add it to the screenshot folder