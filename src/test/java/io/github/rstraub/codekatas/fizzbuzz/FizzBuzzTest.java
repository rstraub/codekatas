package io.github.rstraub.codekatas.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {
    private FizzBuzz fizzBuzz;

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @ParameterizedTest
    @MethodSource("getNumbersNotDivisibleByThreesOrFives")
    void numberShouldBeReturnedWhenValueIsNotDivisibleByThreeAndOrFive(int number) {
        var text = fizzBuzz.getText(number);

        assertEquals(String.valueOf(number), text);
    }

    @ParameterizedTest
    @MethodSource("getNumbersDivisibleByJustThrees")
    void fizzShouldBeReturnedWhenValueIsDivisibleByThree(int number) {
        var text = fizzBuzz.getText(number);

        assertEquals("fizz", text);
    }

    @ParameterizedTest
    @MethodSource("getNumbersDivisibleByJustFives")
    void buzzShouldBeReturnedWhenValueIsDivisibleByFive(int number) {
        var text = fizzBuzz.getText(number);

        assertEquals("buzz", text);
    }

    @ParameterizedTest
    @MethodSource("getNumbersDivisibleByThreeAndFive")
    void fizzBuzzShouldBeReturnedWhenValueIsDivisibleByThreeAndFive(int number) {
        var text = fizzBuzz.getText(number);

        assertEquals("fizzbuzz", text);
    }

    private static List<Integer> getNumbersNotDivisibleByThreesOrFives() {
        return getNumbersNotDivisibleBy(3, 5);
    }

    private static List<Integer> getNumbersDivisibleByJustFives() {
        return getNumbersDividableByJust(5);
    }

    private static List<Integer> getNumbersDivisibleByJustThrees() {
        return getNumbersDividableByJust(3);
    }

    private static List<Integer> getNumbersDividableByJust(int number) {
        var threesAndFives = getNumbersDivisibleByThreeAndFive();
        var residualNumbers = getNumbersDivisibleBy(number);

        threesAndFives
                .forEach(residualNumbers::remove);

        return residualNumbers;
    }

    private static List<Integer> getNumbersDivisibleByThreeAndFive() {
        return getNumbersDivisibleBy(3, 5);
    }

    private static List<Integer> getNumbersDivisibleBy(int... dividers) {
        List<Integer> divisibles = new ArrayList<>();

        for (int index = 1; index <= 100; index++) {
            boolean divisible = true;
            for (int divider : dividers) {
                if (!(index % divider == 0))
                    divisible = false;
            }

            if (divisible)
                divisibles.add(index);
        }

        return divisibles;
    }

    private static List<Integer> getNumbersNotDivisibleBy(int... dividers) {
        List<Integer> indivisibles = new ArrayList<>();

        for (int index = 1; index <= 100; index++) {
            boolean indivisible = true;
            for (int divider : dividers) {
                if (index % divider == 0)
                    indivisible = false;
            }

            if (indivisible)
                indivisibles.add(index);
        }

        return indivisibles;
    }
}
