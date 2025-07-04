Feature: Purchase Order from Ecommerce Site

  As a user,
  I want to purchase products from the ecommerce site,
  So that I can receive my desired items conveniently.

  Background:
    Given I am on the Ecommerce Home Page

  @purchase
  Scenario Outline: Successful and unsuccessful order submission
    Given I log in using Gmail "<gmail>" and Password "<password>"
    When I add the product "<productName>" to the cart
    And I proceed to checkout , verify the "<productName>"and submit the order
    Then I should see "<expectedMessage>"

    Examples: 
  | gmail                        | password   | productName      | expectedMessage                | 
  | satyabratapatra299@gmail.com | Satya@123  | ZARA COAT 3      | THANKYOU FOR THE ORDER.        |
