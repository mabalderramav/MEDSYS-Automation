@regression @availableSchedulesOfADoctor
Feature: Available schedules of a doctor
  As a patient
  I want to see the available schedules of a doctor
  So that I can book an appointment

  Background:
    Given I get a valid token with endpoint "auth"

  @testCase40
  Scenario: Get available schedules of a doctor
    When I get the available schedules of a doctor with endpoint "appointment/2024-03-07/1"
    Then the response status code should be 200
    And the available schedules of a doctor should be returned
