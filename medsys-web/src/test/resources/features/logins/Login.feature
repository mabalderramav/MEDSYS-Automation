@regression @smoke @login
Feature: Login
  As a user
  I want to login
  So that I can access the application

  @testCase43
  Scenario: Successful login
    Given I login to "MEDSYS" portal web with "USER-PASSWORD" credentials
    Then I should see the MEDSYS portal home page