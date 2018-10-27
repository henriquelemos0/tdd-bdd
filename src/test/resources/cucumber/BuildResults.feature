# language: en
Feature: Build results from one runner

  Scenario: Build results based on a race with one runner and one lap

    Given the following laps:
      | pilotCode  | pilotName  | lap   | lapTime | avgSpeed |
      | 001        | MASSA      | 1     | 60000   | 50.00    |

    When the results are built

    Then the result board is:
        | finalPosition | pilotCode | pilotName | finishedLaps | completedLaps | totalElapsedTime  |
        | 1             | 001       | MASSA     | 1            | 1             | 1:00.000          |
