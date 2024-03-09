@regression @smoke @login
Feature: Login
  As a user
  I want to login
  So that I can access the application

  @testCase43
  Scenario: Successful login
    Given I login to "MEDSYS" portal web with "USER-PASSWORD" credentials
    Then I should see the MEDSYS portal home page

  Scenario: Unsuccessful login
    Given I login to "MEDSYS" portal web with "USER-PASSWORD-FAKE" credentials
    Then I should see the login page with error message "Correo no encontrado"