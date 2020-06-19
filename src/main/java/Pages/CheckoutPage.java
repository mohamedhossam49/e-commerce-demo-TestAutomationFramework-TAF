package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CheckoutPage extends PageBase {
    public CheckoutPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 30);
    }
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/input[2]")
    WebElement registerButton;

    @FindBy(id = "gender-male")
    WebElement genderMaleButton;

    @FindBy(id = "FirstName")
    WebElement firstNameField;

    @FindBy(id = "LastName")
    WebElement lastNameField;

    @FindBy(id = "Email")
    WebElement emailField;

    @FindBy(id = "Password")
    WebElement passwordField;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordField;

    @FindBy(id = "register-button")
    WebElement registerSubmitButton;

    @FindBy(css = "body > div.master-wrapper-page > div.master-wrapper-content > div >" +
            " div > form > div > div.page-body > div.result")
    public WebElement registrationSuccessMessage;

    @FindBy(name = "register-continue")
    WebElement continueRegisterPageButton;

    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement countryListMenu;

    @FindBy(id = "BillingNewAddress_City")
    WebElement cityField;

    @FindBy(id = "BillingNewAddress_Address1")
    WebElement address1Field;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement zipCodeField;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phoneNumberField;

    @FindBy(css = "#billing-buttons-container > input")
    WebElement continueBillingPageButton;

    @FindBy(css = "#shipping-method-buttons-container > input")
    WebElement continueShippingMethodPageButton;

    @FindBy(css = "#payment-method-buttons-container > input")
    WebElement continuePaymentMethodPageButton;

    @FindBy(css = "#payment-info-buttons-container > input")
    WebElement continuePaymentInfoPageButton;

    @FindBy(css = "#confirm-order-buttons-container > input")
    WebElement confirmOrderButton;

    @FindBy(css = "#shopping-cart-form > div.table-wrapper > table > tbody > tr > td.product > a")
    public WebElement productNameFieldInConfirmPage;

    @FindBy(css = "body > div.master-wrapper-page > div.master-wrapper-content > div > div > div >" +
            " div.page-body.checkout-data > div > div.title > strong")
    public WebElement orderSuccessConfirmMessage;

    @FindBy(linkText = "Click here for order details.")
    WebElement orderDetailsPageLink;

    public void openUserRegisterPage() {
        wait.until(ExpectedConditions.visibilityOf(registerButton));
        clickButton(registerButton);
        //Thread.sleep(3000);
    }
    public void newUserRegisteration(String firstName, String lastName, String email,
                                     String password){
        clickButton(genderMaleButton);

        EnterText(firstNameField,firstName);
        EnterText(lastNameField,lastName);
        EnterText(emailField,email);

        EnterText(passwordField,password);
        EnterText(confirmPasswordField,password);

        clickButton(registerSubmitButton);
    }
    public void continueToCheckout()  {
       // Thread.sleep(3000);
        clickButton(continueRegisterPageButton);
    }
    public void checkOutByMoneyOrder(String Country, String City, String Address1
            ,String ZIPcode, String phoneNumber )  {
        select = new Select(countryListMenu);
        select.selectByVisibleText(Country);
        EnterText(cityField,City);
        EnterText(address1Field,Address1);
        EnterText(zipCodeField,ZIPcode);
        EnterText(phoneNumberField,phoneNumber);
       // Thread.sleep(1000);
        clickButton(continueBillingPageButton);

       // Thread.sleep(1000);
        clickButton(continueShippingMethodPageButton);

       // Thread.sleep(1000);
        clickButton(continuePaymentMethodPageButton);

       // Thread.sleep(1000);
        clickButton(continuePaymentInfoPageButton);

    }
    public void confirmOrder() {
        clickButton(confirmOrderButton);
        //Thread.sleep(1000);
    }
    public void openOrderDetailsPage()  {
        clickButton(orderDetailsPageLink);
        //Thread.sleep(4000);
    }


}
