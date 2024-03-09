@regression @specialty
Feature: Specialty
  As a user
  I want to be able to see the specialty of a doctor
  So that I can know what type of doctor they are

  Background:
    Given I get a valid token with endpoint "auth"

  @testCase39
  Scenario: See all specialties to display at medical appointments
    When I get the specialties with endpoint "specialty"
    Then the specialties response status should be 200
    And the specialties response should have a list of specialties
