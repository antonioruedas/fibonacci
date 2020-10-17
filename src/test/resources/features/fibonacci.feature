Feature: Fibonacci calculations

  Scenario Outline: client wants to calculate the fibonacci number of a number
    When the client calls the fibonacci function with value <number>
    Then the client receives answer as <result>

    Examples:
      | number  | result |
      | 2       | 1      |
      | 3       | 2      |
      | 4       | 3      |

