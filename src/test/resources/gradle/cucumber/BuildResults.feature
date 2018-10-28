# language: en
Feature: Build results from one runner

  Scenario: Build results based on a race with one runner and one lap

    Given the following laps:
      | pilotCode  | pilotName  | lap   | lapTime | avgLapSpeed |
      | 001        | MASSA      | 1     | 60000   | 50.00       |

    When the results are built

    Then the result board is:
        | finalPosition | pilotCode | pilotName | completedLaps | totalElapsedTime  |
        | 1             | 001       | MASSA     | 1             | 1:00.000          |


  Scenario: Build results based on a race with two runners and one lap each

    Given the following laps:
      | pilotCode  | pilotName  | lap   | lapTime | avgLapSpeed |
      | 001        | MASSA      | 1     | 60000   | 50.00       |
      | 002        | RUBINHO    | 1     | 61000   | 51.00       |

    When the results are built

    Then the result board is:
      | finalPosition | pilotCode | pilotName | completedLaps | totalElapsedTime  |
      | 1             | 001       | MASSA     | 1             | 1:00.000          |
      | 2             | 002       | RUBINHO   | 1             | 1:01.000          |


  Scenario: Build results based on a race with four runners and one lap each

    Given the following laps:
      | pilotCode  | pilotName  | lap   | lapTime | avgLapSpeed |
      | 001        | MASSA      | 1     | 60000   | 50.00       |
      | 002        | RUBINHO    | 1     | 61000   | 51.00       |
      | 003        | FITTIPALDI | 1     | 59123   | 52.00       |
      | 004        | SENNA      | 1     | 58000   | 53.00       |

    When the results are built

    Then the result board is:
      | finalPosition | pilotCode | pilotName | completedLaps | totalElapsedTime  |
      | 1             | 004       | SENNA     | 1             | 0:58.000          |
      | 2             | 003       | FITTIPALDI| 1             | 0:59.123          |
      | 3             | 001       | MASSA     | 1             | 1:00.000          |
      | 4             | 002       | RUBINHO   | 1             | 1:01.000          |
