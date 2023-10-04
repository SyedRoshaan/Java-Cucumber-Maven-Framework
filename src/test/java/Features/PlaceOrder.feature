Feature: Login Feature

  Scenario Outline: Unsuccessful login with valid credentials
    Given I am on the login page
    When I enter "<username>" and "<password>"
    And I click on the login button
    Then I should see an error message indicating "<error>"

    Examples:
      | username            | password        |   error                                                                   |
      | locked_out_user     | secret_sauce    | Epic sadface: Sorry, this user has been locked out.                       |
      | standrd_user        | secret_sauce    | Epic sadface: Username and password do not match any user in this service |

  Scenario Outline: Successful login with valid credentials
    Given I am on the login page
    When I enter "<username>" and "<password>"
    And I click on the login button
    Then I should be logged in successfully

    Examples:
      | username                  | password        |
      | standard_user             | secret_sauce    |
      | performance_glitch_user   | secret_sauce    |

  Scenario Outline: Sorting Products
    Given I am on inventory page
    When I sort the products by "<order>"
    Then Products are sorted according to the "<order>"

    Examples:
      | order               |
      | Name (A to Z)       |
      | Name (Z to A)       |
      | Price (low to high) |
      | Price (high to low) |

  Scenario: Add Product to cart
    Given I am on inventory page
    When I add "Sauce Labs Backpack" to the cart
    Then Product is successfully added to the cart

  Scenario: Checkout Product
    Given I am on checkout page
    When I go to cart
    And I click checkout button
    And I enter "firstName", "lastName" and "postalCode"
    And I click continue button
    And I click finish button
    Then Order is placed successfully

  Scenario: Logout
    Given I am on inventory page
    When I click side menu
    And I click logout button
    Then I should be logged out successfully


