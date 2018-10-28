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
