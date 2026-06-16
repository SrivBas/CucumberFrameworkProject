Feature: Add Employee into HRMS
  Background:
    Given user is able to launch HRMS application
    When user enters valid username and password
    And user clicks on login button
    Then user is able to logged in successfully.
    When user clicks on PIM
    And user clicks on Add Employee

  @add
  Scenario Outline:Add Employee by firstname ,middlename and lastname
    When user enters "<Firstname>""<Middlename>""<Lastname>"
    And click on save button
    Then the employee should added successfully
    And employee Id should be generated automatically
    And Verify the employee record from the employee list

    Examples:
      |Firstname |Middlename|Lastname|
      | samy     |(Gopala)  |Krishnan|
      |John      |          |Andre   |

   @addId
   Scenario Outline: Add employee by firstname,middlename,lastname and employeeId

      When user enters "<firstname>""<middlename>""<lastname>""<EmployeeId>"
      And click on save button
      Then the employee should added successfully
      And Verify the employee record from the employee list

     Examples:
       |firstname |middlename| lastname|EmployeeId|
       | Mark      | Ms         | Anthony  |E005|
       | John      |            | Andre    |E006 |


    @validate
    Scenario Outline: Add employee with firstname,lastname validation
      When user enters "<firstname>""<lastname>"
      And click on save button
      Then "Required" message should be displayed
      Examples:
        |firstname | lastname|
        |John      |         |
        |          |Smith    |

     @duplicate
    Scenario: Add Employee with Duplicate id
      When user enters employee id
      Then the error message should be displayed
