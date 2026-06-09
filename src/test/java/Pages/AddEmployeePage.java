package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {
    public AddEmployeePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//span[text()='PIM']")
    public WebElement pimBtn;

    @FindBy(xpath="//input[@name='firstName']")
    public WebElement firstName;

    @FindBy(xpath="//input[@name='middleName']")
    public WebElement middleName;

    @FindBy(xpath="//input[@name='lastName']")
    public WebElement lastName;

    @FindBy(xpath="//button[text()=' Save ']")
    public WebElement saveBtn;

    @FindBy(xpath="//a[text()='Add Employee']")
    public WebElement addEmployeeBtn;

    //@FindBy(xpath="(//input[@class=\"oxd-input oxd-input--active\"])[2]")
    @FindBy(xpath="//label[text()='Employee Id']/following::input[1]")
    public WebElement employeeId;

    @FindBy(xpath="//h6[text()='Personal Details']")
    public WebElement personalDetailheader;

    @FindBy(xpath="//span[text()='Required']")
    public WebElement errorMsg;

    @FindBy(xpath="//span[text()='Employee Id already exists']")
    public WebElement errorMsgID;

    @FindBy(xpath="//a[text()='Employee List']")
    public WebElement employeeList;

    @FindBy(xpath="//button[text()=' Search ']")
    public WebElement search;

    //@FindBy(xpath="//div[@class=\"oxd-table-cell oxd-padding-cell\"][2]")
    @FindBy(xpath="(//div[@role='row'])[2]//div[2]")
    public WebElement searchID;

}
