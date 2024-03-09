@regression @smoke @doctorsBySpeciality
Feature: Doctors by Speciality
  As a user
  I want to find doctors by speciality
  So that I can find a doctor to treat my condition

  @testCase37
  Scenario: Search for doctors by speciality
    Given I get a valid token with endpoint "auth"
    When I send a GET request to search doctors by speciality endpoint "doctor/specialty/1"
    Then the doctors by speciality response status should be 200
    And the response should gets a list of doctors by speciality
