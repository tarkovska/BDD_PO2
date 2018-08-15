Feature: Buy
  As a user
  I want to buy soutage product
  So that I find soutage category and choose from list of products

  Scenario: Buy
    Given I am on the "Company home" page on URL "http://tartka.com.ua/en/"
    When I fill in with "soutage"
    Then I am on the "http://tartka.com.ua/?s=soutage&post_type=product" page
    When I click on the first product
    And I put it to cart
    And I go to my cart
    And I proceed to checkout
    And Fill customer's name "Ivan"
    And Fill customer's surname "Ivanov"
    And Fill customer's email "ivanov@gmail.com"
    And Fill customer's phone "0504545458"
    And Click terms
    Then I can see succesful checkout page with message "Thank you. Your order has been received."



    Scenario Outline: Buy

    Given I am on the "Company home" page on URL "http://tartka.com.ua/en/"
        When I fill in with "soutage"
        Then I am on the "http://tartka.com.ua/?s=soutage&post_type=product" page
        When I click on the first product
        And I put it to cart
        And I go to my cart
        And I proceed to checkout
        And Fill customer's name "<name>"
        And Fill customer's surname "<surname>"
        And Fill customer's email "<email>"
        And Fill customer's phone "<phone>"
        And Click terms
        Then I can see unsuccesful checkout page with message "<message>"

      Examples:
        |name         | surname       |email                        |phone          |message                                    |
        |Inna         |               |zemlya@gmail.com             |654545465444   |Billing Фамилия is a required field.       |
        |             |Zemlya         |zemlya@gmail.com             |654545465444   |Billing Имя is a required field.           |
        |Inna         |Zemlya         |zemlya@gmail.com             |               |Billing Телефон is a required field.       |
        |Inna         |Zemlya         |                             |654545465444   |Billing Email is a required field.         |
        |Inna         |Zemlya         |zemlya@gmail                 |654545465444   |Billing Email is not a valid email address.|