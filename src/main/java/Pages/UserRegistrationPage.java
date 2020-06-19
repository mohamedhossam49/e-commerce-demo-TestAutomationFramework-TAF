package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class UserRegistrationPage extends PageBase {
public Select selectDayofBirth;
public Select selectMonthofBirth;
public Select selectYearofBirth;

    public UserRegistrationPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 50);
    }
    @FindBy(id = "gender-male")
    WebElement genderMaleButton;

    @FindBy(id = "gender-female")
    WebElement genderFemaleButton;

    @FindBy(id = "FirstName")
    WebElement firstNameField;

    @FindBy(id = "LastName")
    WebElement lastNameField;

    @FindBy(id = "Email")
    WebElement emailField;

    @FindBy(name = "DateOfBirthDay")
    WebElement dayOfBirthDropDown;

    @FindBy(name = "DateOfBirthMonth")
    WebElement monthOfBirthDropDown;

    @FindBy(name = "DateOfBirthYear")
    WebElement yearOfBirthDropDown;

    @FindBy(id = "Password")
    WebElement passwordField;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordField;

    @FindBy(id = "register-button")
    WebElement registerButton;

    @FindBy(css = "div.result")
    public WebElement registrationSuccessMessage;

    @FindBy(linkText = "Log out")
    WebElement logoutButton;


public void userRegistration(String firstname, String lastname, String email,
                             String password, String dayofBirth, String monthofBirth,
                             String yearofBirth) {
selectDayofBirth = new Select(dayOfBirthDropDown);
selectMonthofBirth = new Select(monthOfBirthDropDown);
selectYearofBirth =  new Select(yearOfBirthDropDown);
List<WebElement> userRegisterFields = Arrays.asList(genderMaleButton,firstNameField,lastNameField
        , dayOfBirthDropDown, monthOfBirthDropDown, yearOfBirthDropDown,
        emailField,passwordField,confirmPasswordField);
//Thread.sleep(3000);
wait.until(ExpectedConditions.visibilityOfAllElements(userRegisterFields));

clickButton(genderMaleButton);
EnterText(firstNameField,firstname);

EnterText(lastNameField,lastname);
selectDayofBirth.selectByVisibleText(dayofBirth);
selectMonthofBirth.selectByVisibleText(monthofBirth);
wait.until(ExpectedConditions.visibilityOf(yearOfBirthDropDown));
selectYearofBirth.selectByVisibleText(yearofBirth);
EnterText(emailField,email);

EnterText(passwordField,password);

EnterText(confirmPasswordField,password);
clickButton(registerButton);
}
public void RegisteredUserLogout(){
    clickButton(logoutButton);
}

}
