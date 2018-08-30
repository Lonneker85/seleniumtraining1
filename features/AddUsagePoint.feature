Feature: Test adding a usage point

  Scenario Outline: user should be able to add a new usage point
    Given user is logged in and on usage point overview
#    When user adds a new usage point with <name> and <serviceCategory> and <typeOfUsagePoint> and <marketCodeSector> and <meteringPointType>
    And user adds a usage point group with test

    Examples:
      | name          | serviceCategory | typeOfUsagePoint | marketCodeSector        | meteringPointType |
      | UPElectricity | Electricity     | Physical SDP     | Domestic                | E17 - Consumption |
#      | UPGas         | Gas             | Physical non-SDP | Industrial & Commercial | E18 - Production  |