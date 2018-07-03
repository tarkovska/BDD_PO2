Feature: Search
  As a user
  I want to search
  So that I find soutage

  Scenario: Search
  Given I am on the "Company home" page on URL "http://tartka.com.ua/en/"
  When I fill in with "soutage"
  Then I am on the "http://tartka.com.ua/?s=soutage&post_type=product" page