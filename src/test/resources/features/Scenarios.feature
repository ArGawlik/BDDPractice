Feature: Test scenario for Amazon

  Scenario Outline: Change zip code
    Given User is on "Main Page"
    When User on "Main Page" set zip code as "<zipCode>" and click Apply button
    Then On "Main Page" delivery icon contains "<deliveryLocation>"
    Examples:
      | zipCode | deliveryLocation |
      | 36104   | Montgomery       |
      | 85001   | Phoenix          |
      | 87501   | Santa Fe         |

  Scenario Outline: Change deliver country
    Given User is on "Main Page"
    When User on "Main Page" set country as "<countryName>" and click Done button
    When User on "Main Page" clicks on Headsets link
    Then User is navigated to "Search Page"
    When User on "Search Page" clicks on the first product
    Then User is navigated to "Product Page"
    And On "Product Page" the country name is "<countryName>"
    Examples:
      | countryName |
      | Austria     |
      | India       |
      | Germany     |

  Scenario Outline: Enter invalid zip code
    Given User is on "Main Page"
    When User on "Main Page" set invalid zip code  "<zipCode>" and click Apply button
    Then On Delivery Module appears message "Please enter a valid US zip code"
    Examples:
      | zipCode |
      | 9999922 |
      | 11111   |
      | 4       |
      | asdgf   |

  Scenario Outline: Search for item using search bar
    Given User is on "Main Page"
    When User on "Main Page" search for "<keyword>" keyword
    Then User is navigated to "Search Page"
    And Results header on "Search Page" contains "<keyword>" keyword
    Examples:
      | keyword     |
      | mouse       |
      | nice laptop |

  Scenario: Negative search for item using search bar
    Given User is on "Main Page"
    When User on "Main Page" search for "ofgj87bwsnf8934hr" keyword
    Then User is navigated to "Search Page"
    And On "Search Page" the message No results for "ofgj87bwsnf8934hr" is shown

  Scenario Outline: Negative registration
    Given User is on "Main Page"
    When User on "Main Page" move cursor to Account Box and click Start here
    Then User is navigated to "Registration Page"
    When User on "Registration Page" fill Your name with "<name>" Mobile number or mail with "<mailOrPhone>" Password with "<password>" and Re-enter password with "<passwordCheck>"
    Then "<errorMessage>" should append on "Registration Page"
    Examples:
      | name  | mailOrPhone   | password  | passwordCheck | errorMessage                                   |
      | Arek  | 867495094     | qwerty123 | qwerty768     | Passwords must match                           |
      | Arek1 | asd@com       | qwerty123 | qwerty123     | Wrong or Invalid email address or mobile phone |
      |       | asd@gmail.com | qwe       | qwe           | Enter your name                                |
      |       | asd@gmail.com | qwe       | qwe           | Minimum 6 characters required                  |
