package utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CommonMethods extends PageInitialiser{
    public static WebDriver driver;

    public void openBrowser(){

        switch (ConfigReader.read("browser")){
            case "Chrome":
                driver=new ChromeDriver();
                break;

            case "Edge":
                driver=new EdgeDriver();
                break;

            case "FireFox":
                driver=new FirefoxDriver();
                break;
            case "Safari":
                driver=new SafariDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        initilizePageObjects();
    }
    public void closeBrowser(){
        if(driver!=null){
            driver.quit();
        }
    }

    public WebDriverWait getwait(){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(Constants.Explicit_Wait));
        return  wait;
    }

    public void waitForElementToBeClickAble(WebElement element){
        getwait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(WebElement element){
        waitForElementToBeClickAble(element);
        element.click();
    }
    public void visible(WebElement element){
        getwait().until(ExpectedConditions.visibilityOf(element));
    }
    public void waitforValue(WebElement element){
        getwait().until(
                ExpectedConditions.attributeToBeNotEmpty(element, "value"));
    }
    public void sendText(String text, WebElement element){
        element.clear();
        element.sendKeys(text);
    }
   public void clear(WebElement element){
       click(element);
       element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
       element.sendKeys(Keys.BACK_SPACE);
    }


    public void searchEmployeeId(String empId) {
        addEmployeePage.employeeList.click();
        //click(addEmployeePage.employeeId);
        sendText(empId,addEmployeePage.employeeId);
        click(addEmployeePage.search);
        //getwait().until(ExpectedConditions.textToBePresentInElement(addEmployeePage.searchID, empId));
        String actual=addEmployeePage.searchID.getText().trim();
        System.out.println("actual "+actual);
        Assert.assertEquals(empId,actual);


    }




}
