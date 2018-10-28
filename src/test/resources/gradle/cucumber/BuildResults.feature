# language: en
Feature: Build results

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


  Scenario: Build results based on a race with five runners and fore laps

    Given the following laps:
      | pilotCode  | pilotName  | lap   | lapTime | avgLapSpeed |
      | 038        | MASSA      | 1     | 62852   | 50.00       |
      | 033        | BARRICHELLO| 1     | 64352   | 51.00       |
      | 002        | RAIKKONEN  | 1     | 64108   | 52.00       |
      | 023        | WEBBER     | 1     | 64414   | 53.00       |
      | 015        | ALONSO     | 1     | 78456   | 53.00       |
      | 038        | MASSA      | 2     | 63170   | 53.00       |
      | 033        | BARRICHELLO| 2     | 64002   | 53.00       |
      | 002        | RAIKKONEN  | 2     | 63982   | 53.00       |
      | 023        | WEBBER     | 2     | 64805   | 53.00       |
      | 015        | ALONSO     | 3     | 67011   | 53.00       |
      | 038        | MASSA      | 3     | 62769   | 53.00       |
      | 033        | BARRICHELLO| 3     | 63716   | 53.00       |
      | 002        | RAIKKONEN  | 3     | 63987   | 53.00       |
      | 023        | WEBBER     | 3     | 64287   | 53.00       |
      | 015        | ALONSO     | 3     | 68704   | 53.00       |
      | 011        | VETTEL     | 1     | 211315  | 53.00       |
      | 038        | MASSA      | 4     | 62787   | 53.00       |
      | 033        | BARRICHELLO| 4     | 64010   | 53.00       |
      | 002        | RAIKKONEN  | 4     | 63076   | 53.00       |
      | 023        | WEBBER     | 4     | 64216   | 53.00       |
      | 015        | ALONSO     | 4     | 80050   | 53.00       |
      | 011        | VETTEL     | 2     | 97864   | 53.00       |
      | 011        | VETTEL     | 3     | 78097   | 53.00       |

    When the results are built

    Then the result board is:
      | finalPosition | pilotCode | pilotName  | completedLaps | totalElapsedTime  |
      | 1             | 038       | MASSA      | 4             | 4:11.578          |
      | 2             | 002       | RAIKKONEN  | 4             | 4:15.153          |
      | 3             | 033       | BARRICHELLO| 4             | 4:16.080          |
      | 4             | 023       | WEBBER     | 4             | 4:17.722          |
      | 5             | 015       | ALONSO     | 4             | 4:54.221          |
      | 6             | 011       | VETTEL     | 3             | 6:27.276          |

