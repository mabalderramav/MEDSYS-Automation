@regression @scheduledAppointments
Feature: Scheduled Appointments
  As a user
  I want to see my scheduled appointments
  So that I can keep track of my appointments

  Background:
    Given I get a valid token with endpoint "auth"

  @testCase41
  Scenario: List the patient's scheduled appointments
    When I get the list of scheduled appointments with endpoint "appointment/patient/6"
    Then the scheduled appointments response status code should be 200
    And the scheduled appointments response should have a list of appointments with the following fields
      | appointmentId | hour     | doctorId | fullname                      | specialty   | patientId | dateRegisterPatient      |
      | 2             | 08:15:00 | 1        | Mario Alfredo Martinez Amaral | Cardiología | 6         | 2024-03-05T00:00:00.000Z |
