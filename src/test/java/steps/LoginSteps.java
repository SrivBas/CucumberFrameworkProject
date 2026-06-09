package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginSteps extends CommonMethods {

    @Given("user is able to launch HRMS application")
    public void user_is_able_to_launch_hrms_application() {
        driver.get(ConfigReader.read("url"));
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() throws InterruptedException {


        sendText(ConfigReader.read("userName"), loginPage.usernameloc);
        Thread.sleep(1000);

        sendText(ConfigReader.read("password"), loginPage.passwordloc);


    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        click(loginPage.loginBtn);
    }

    @Then("user is able to logged in successfully.")
    public void user_is_able_to_logged_in_successfully() {
        System.out.println("Logged in");
    }

    @When("user enters Invalid username and valid password")
    public void user_enters_invalid_username_and_valid_password() {
        sendText("HRm", loginPage.usernameloc);
        sendText(ConfigReader.read("password"), loginPage.passwordloc);
    }

    @Then("User should see {string} message")
    public void userShouldSeeMessage(String str) {
        Assert.assertTrue(loginPage.errorMessageLoc.isDisplayed());
        String text = loginPage.errorMessageLoc.getText();
        Assert.assertEquals(str, text);
    }


    @When("user enters valid username and Invalid password")
    public void user_enters_valid_username_and_invalid_password() {
        sendText(ConfigReader.read("userName"), loginPage.usernameloc);
        sendText("hrm123", loginPage.passwordloc);
    }


    @When("user empty username and enter valid password")
    public void user_empty_username_and_enter_valid_password() {
        sendText(ConfigReader.read("password"), loginPage.passwordloc);
        loginPage.passwordloc.sendKeys(Keys.CONTROL + "a");
        loginPage.passwordloc.sendKeys(Keys.DELETE);
    }

    @Then("user should see {string} message near username field")
    public void userShouldSeeMessageNearUsernameField(String arg0) {
        loginPage.emptyFieldLoc.isDisplayed();
        String text = loginPage.emptyFieldLoc.getText();
        Assert.assertEquals(arg0, text);

    }


    @When("user  enter valid username and empty password")
    public void user_enter_valid_username_and_empty_password() {
        sendText(ConfigReader.read("userName"), loginPage.usernameloc);
        loginPage.usernameloc.sendKeys(Keys.CONTROL + "a");
        loginPage.usernameloc.sendKeys(Keys.DELETE);
    }

    @Then("user should see {string} message near password field")
    public void user_should_see_message_near_password_field(String string) {
        loginPage.emptyFieldLoc.isDisplayed();
        String text = loginPage.emptyFieldLoc.getText();
        Assert.assertEquals(string, text);
    }

}
