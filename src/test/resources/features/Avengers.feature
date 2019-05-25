Feature: Avengers application

  Scenario: Register an avenger to S.H.I.E.L.D
    Given I am fury  and I want to add a new avenger
    When I provide name as Gullu and rank as 10 and power GOAT
    Then Gullu becomes member of S.H.I.E.L.D