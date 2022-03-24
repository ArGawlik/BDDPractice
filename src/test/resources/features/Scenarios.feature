Feature: Test scenario for Amazon
  Scenario Outline: Change zip code
    Given User is on "Main Page"
    When User on "Main Page" set zip code as "<zipCode>" and click Apply button
    Then On "Main Page" delivery icon contains "<deliveryLocation>"
    Examples:
      |zipCode  | deliveryLocation  |
      |36104    |Montgomery         |
      |85001    |Phoenix            |
      |87501    |Santa Fe           |

  Scenario Outline: Change deliver country
    Given User is on "Main Page"
    When User on "Main Page" set country as "<countryName>" and click Done button
    When User on "Main Page" clicks on Headsets link
    Then User is navigated to "Search Page"
    When User on "Search Page" clicks on the first product
    Then User is navigated to "Product Page"
    And On "Product Page" the country name is "<countryName>"
    Examples:
    |countryName|
    |Austria    |
    |India      |
    |Germany    |
