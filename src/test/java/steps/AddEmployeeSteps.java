package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;

public class AddEmployeeSteps extends CommonMethods {
    String empId;


    @When("user clicks on PIM")
    public void user_clicks_on_pim() {
       click(addEmployeePage.pimBtn);
    }

    @When("user clicks on Add Employee")
    public void user_clicks_on_add_employee() {
        click(addEmployeePage.addEmployeeBtn);
    }


    @When("user enters {string}{string}{string}")
    public void user_enters(String string, String string2, String string3) {
        sendText(string,addEmployeePage.firstName);
        sendText(string2,addEmployeePage.middleName);
        sendText(string3, addEmployeePage.lastName);
    }


    @When("click on save button")
    public void click_on_save_button() {
        click(addEmployeePage.saveBtn);
    }

    @Then("the employee should added successfully")
    public void the_employee_should_added_successfully() {
        visible(addEmployeePage.personalDetailheader);
        Assert.assertTrue(addEmployeePage.personalDetailheader.isDisplayed());
    }
    @Then("employee Id should be generated automatically")
    public void employee_id_should_be_generated_automatically()  {
        waitforValue(addEmployeePage.employeeId);
        String generatedEmpId=addEmployeePage.employeeId.getAttribute("value");
        empId=generatedEmpId;
        //System.out.println("Employee ID:["+empId+"]");
    }

    @Then("Verify the employee record from the employee list")
    public void verify_the_employee_record_from_the_employee_list() throws InterruptedException {
         searchEmployeeId(empId);
    }

    @When("user enters {string}{string}{string}{string}")
    public void user_enters(String string, String string2, String string3, String string4) {
        String expectedEmpId =string4;
        sendText(string,addEmployeePage.firstName);
        sendText(string2,addEmployeePage.middleName);
        sendText(string3, addEmployeePage.lastName);

        clear(addEmployeePage.employeeId);
        sendText(string4, addEmployeePage.employeeId);
        empId=string4;
    }

    @When("user enters {string}{string}")
    public void user_enters(String string, String string2) {
        sendText(string,addEmployeePage.firstName);
        sendText(string2, addEmployeePage.lastName);
        click(addEmployeePage.saveBtn);

    }


    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String expectedMessage) {

        String actualMessage=addEmployeePage.errorMsg.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @When("user enters employee id")
    public void user_enters_employee_id() {
        clear(addEmployeePage.employeeId);
        sendText("EMP010", addEmployeePage.employeeId);
    }
    @Then("the error message should be displayed")
    public void the_error_message_should_be_displayed() {
        String actual=addEmployeePage.errorMsgID.getText().trim();
        Assert.assertEquals("Employee Id already exists",actual);
    }



}
