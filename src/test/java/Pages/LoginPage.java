package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {

    public LoginPage (){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//input[@name='username']")
    public WebElement usernameloc;

    @FindBy(xpath="//input[@name='password']")
    public WebElement passwordloc;

    @FindBy(xpath="//button[contains(@class,'orangehrm-login-button')]")
    public WebElement loginBtn;

    @FindBy(xpath="//p[text()='Invalid credentials']")
    public WebElement errorMessageLoc;


    @FindBy(xpath="//span[text()='Required']")
    public WebElement emptyFieldLoc;






}
