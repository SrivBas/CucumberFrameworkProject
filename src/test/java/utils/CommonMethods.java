package utils;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class CommonMethods extends PageInitialiser{
    public static WebDriver driver;

    public void openBrowser(){

        switch (ConfigReader.read("browser")){
            case "Chrome":
                        ChromeOptions options = new ChromeOptions();
                        //options.addArguments("--headless=new");
                        options.addArguments("--window-size=1920,1080");
                        options.addArguments("--disable-gpu");
                        options.addArguments("--no-sandbox");
                        options.addArguments("--disable-dev-shm-usage");
                        driver = new ChromeDriver(options);

                //driver=new ChromeDriver();
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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


    public void searchEmployeeId(String empId) throws InterruptedException {
        addEmployeePage.employeeList.click();
        //click(addEmployeePage.employeeId);
        sendText(empId,addEmployeePage.employeeId);
        click(addEmployeePage.search);

                /*getwait().until(ExpectedConditions.visibilityOf(addEmployeePage.getSearchID));*/

        //String actual = addEmployeePage.getSearchID.getText().trim();
        String actual=addEmployeePage.getEmployeeIdFromResult(empId);
        //ystem.out.println("actual "+actual);
        Assert.assertEquals(empId,actual);


    }
    public String getEmployeeIdFromResult(String empId) {
        //By employeeIdResult = By.xpath("(//div[@role='row'])[2]//div[2]");

        //return addEmployeePage.getSearchID.getText().trim();
        //By employeeIdResult = By.xpath("(//div[@role='row'])[2]//div[2]");
        By employeeIdResult = By.xpath("//div[@role='row']//div[normalize-space()='" + empId + "']");
        WebElement employee =
                getwait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(employeeIdResult)));

        return employee.getText().trim();


    }



    public byte[] takeScreenshot(String fileName){

        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picByte = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile,
                    new File(Constants.SCREENSHOT_FILEPATH +
                            fileName+" "+
                            getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picByte;
    }


    public String getTimeStamp(String pattern){

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }




}
