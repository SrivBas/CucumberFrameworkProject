Feature: Login Related functionality

  Background:
    Given user is able to launch HRMS application

   @valid
   Scenario: Valid username and password
    When user enters valid username and password
    And user clicks on login button
    Then user is able to logged in successfully.

    @InvalidUser
    Scenario: Invalid Username and valid password
      When user enters Invalid username and valid password
      And user clicks on login button
      Then User should see "Invalid credentials" message

      When user enters valid username and password
      And user clicks on login button
      Then user is able to logged in successfully.

  @Invalidpassword
  Scenario: Invalid Username and valid password
    When user enters valid username and Invalid password
    And user clicks on login button
    Then User should see "Invalid credentials" message

    When user enters valid username and password
    And user clicks on login button
    Then user is able to logged in successfully.

    @emptyuser
    Scenario: Empty username textbox
     When user empty username and enter valid password
     And user clicks on login button
      Then user should see "Required" message near username field

      When user enters valid username and password
      And user clicks on login button
      Then user is able to logged in successfully.

  @emptypassword
  Scenario: Empty password textbox
    When user  enter valid username and empty password
    And user clicks on login button
    Then user should see "Required" message near password field

    When user enters valid username and password
    And user clicks on login button
    Then user is able to logged in successfully.