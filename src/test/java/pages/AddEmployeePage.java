package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy (id = "middleName")
    public WebElement middleName;

    @FindBy (id = "lastName")
    public WebElement lastName;

    @FindBy (id = "employeeId")
    public WebElement employeeID;

    @FindBy (id = "photofile")
    public WebElement photograph;

    @FindBy (id = "btnSave")
    public WebElement saveBtn;

    @FindBy (id = "chkLogin")
    public WebElement createLoginDetails;

    @FindBy (id = "user_name")
    public WebElement usernameCreate;

    @FindBy (id = "user_password")
    public WebElement userPassword;

    @FindBy (id = "re_password")
    public WebElement rePassword;

    @FindBy (id = "status")
    public WebElement status;

    public void enterFirstAndLastName(String firstname, String lastname) {
        sendText(firstName, firstname);
        sendText(lastName, lastname);
    }

    public void enterFirstMiddleLastName(String firstname, String middlename, String lastname) {
        sendText(firstName, firstname);
        sendText(middleName, middlename);
        sendText(lastName, lastname);
    }

    public void enterLoginDetails(String username, String password) {
        sendText(usernameCreate, username);
        sendText(userPassword, password);
        sendText(rePassword, password);
    }

    public void enterEmployeeId(String employeeid) {
        sendText(employeeID, employeeid);
    }

    public void clickOnSaveBtn() {
        saveBtn.click();
    }

    public void clickOnLoginDetails() {
        createLoginDetails.click();
    }

    public AddEmployeePage() {
        PageFactory.initElements(driver, this);
    }
}
