package primeFactors;

import java.util.*;

public class PrimeFactors {

    public ArrayList<Integer> generate(int number) {
        ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
        int factor = 2;

        while (factor <= number) {
            int divisionRest = number % factor;
            if (divisionRest == 0) {
                number /= factor;
                if (primeNumbers.contains(factor) == false) {
                    primeNumbers.add(factor);
                }
            } else {
                factor++;
            }
        }
        return primeNumbers;
    }
}

