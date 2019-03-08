package io.github.rstraub.codekatas.fizzbuzz;

class FizzBuzz {
    String getText(int i) {
        if (i % 15 == 0)
            return "fizzbuzz";
        else if (i % 5 == 0) {
            return "buzz";
        } else if (i % 3 == 0) {
            return "fizz";
        } else {
            return String.valueOf(i);
        }
    }
}
