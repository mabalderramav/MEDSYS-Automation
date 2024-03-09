@regression @doctorsAndSpecialties
Feature: Doctors and Specialties
  As a patient
  I want to see a list of specialties and see the doctors that are available in each specialty
  So that I can find a doctor that meets my needs

  Background:
    Given I login to "MEDSYS" portal web with "USER-PASSWORD" credentials

  @testCase55
  Scenario: Displays a list of specialties
    When I click on 'Especialidad' dropdown
    Then I should see a list of specialties
      | Cardiología       |
      | Dermatología      |
      | Gastroenterología |
      | Oftalmología      |
      | Pediatría         |

  @testCase56
  Scenario: Displays a list of doctors in a specialty
    Given I click on 'Especialidad' dropdown
    And I select "Cardiología" in dropdownItem
    And I click on 'Siguiente' button
    When I click on 'Medico' dropdown
    Then I should see a list of doctors
      | Mario Alfredo Martinez Amaral |
