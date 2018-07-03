Feature: Buy
  As a user
  I want to buy soutage product
  So that I find soutage category and choose from list of products

  Scenario: Search
    Given I am on the "Company home" page on URL "http://tartka.com.ua/en/"
    When I fill in with "soutage"
    Then I am on the "http://tartka.com.ua/?s=soutage&post_type=product" page
    And I click on the first product
    And I put it to cart
    Then I go to my cart
    Then I proceed to checkout
    And Fill customer's name "Ivan"
    And Fill customer's surname "Ivanov"
    And Fill customer's email "ivanov@gmail.com"
    And Fill customer's phone "0504545458"
    And Click terms
    Then I checkout