@regression @smoke @authentication
Feature: Authentication
  As a user
  I want to be able to gets a token
  So that I can log in the application

  @TestCase32
  Scenario: User gets a valid token for logging in
    When I send a request to POST authentication endpoint "auth" with the following data
      | email    | automation@medsys.com |
      | password | {password}            |
    Then I should receive a response with status 200
    And I should receive a response with the following data
      | token    | {token}               |
      | id       | {id}                  |
      | fullName | Automation Test       |
      | email    | automation@medsys.com |