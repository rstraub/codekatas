Feature: Mastermind
  Should tell if a code has been guessed or not

  Scenario: All pegs are wrong
    Given All pegs are wrong
    When The guess is evaluated
    Then The result is 0 correct and 0 misplaced pegs

  Scenario: All pegs are correct
    Given All pegs are correct
    When The guess is evaluated
    Then The result is 4 correct and 0 misplaced pegs

  Scenario: A misplaced peg
    Given A misplaced peg
    When The guess is evaluated
    Then The result is 0 correct and 1 misplaced pegs
