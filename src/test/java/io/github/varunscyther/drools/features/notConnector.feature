Feature: Not Connector Scenarios

  Scenario: Rule doesn't fired as person exist
    Given the person first name as 'VARUN' and last name as 'SINGH' exist in the facts
    And the following address exist for person
  | houseno | streetno    |
  | 77 	    | BELL COURT  |
    When rules get fired
    Then atleast '0' rule is executed

  Scenario: Rule fired as person doesn't exist
    Given the person first name as 'VARUN' and last name as 'SINGH' exist in the facts
    And the following address exist for person
  | houseno | streetno    |
  | 78 	    | BELL COURT  |
    When rules get fired
    Then atleast '2' rule is executed