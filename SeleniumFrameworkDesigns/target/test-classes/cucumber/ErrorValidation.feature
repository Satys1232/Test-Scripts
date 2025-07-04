@tag
Feature: Error Validation
  I am an user who want to simply login 
  and validate that the error message is 
  being appeared or not

  @ErrorValidation
  Scenario Outline: Login error validation
    Given I navigate to the Ecommerce Page for error testing
    And I attempt login with Gmail "<gmail>" and Password "<password>"
    Then I should see error message "<expectedMessage>"

    Examples: 
      | gmail                        | password   | expectedMessage                | 
      | satyabratapatra80@gmail.com  | Satya@123  | Incorrect email or password.   |
