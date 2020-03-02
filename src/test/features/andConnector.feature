Feature: AND Connector Scenarios

  Scenario: Rule should fired as person exist
    Given the person name as 'IMRAN' exist in the facts
    And the following is the address
  | houseno | streetno    |
  | 77 	    | BELL COURT  |
    When rules is triggered
    Then '1' rule is executed