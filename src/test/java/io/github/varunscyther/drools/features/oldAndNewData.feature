Feature: Rule based on old and new condition scenario

  Scenario Outline: Rule fired as person naming information got updated
    Given the person with first name as <firstName> and last name as <lastName> exist in the facts
    And the person name information updated with
      | firstname | lastname |
      | ANITA     | SINGH    |
    When if person first name is updated with following then comparison evaluation needs to be triggered
    Then <ruleName> rule should match to detect change in name

    Examples:
      | firstName     | lastName    | ruleName                                                       |
      | ''VARUN''     |''SINGH''    | ''Rule to validate whether there is change in address or not'' |