package primeFactors;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PrimeFactorsTest {

    @Test
    public void primeFactorsTestForOne() {
        PrimeFactors primeFactors = new PrimeFactors();

        ArrayList<Integer> result = primeFactors.generate(1);
        ArrayList<Integer> expected = new ArrayList<>();

        assertEquals(expected, result);
    }

    @Test
    public void primeFactorsTestForTwo() {
        PrimeFactors primeFactors = new PrimeFactors();

        ArrayList<Integer> result = primeFactors.generate(2);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(2);

        assertEquals(expected, result);
    }

    @Test
    public void primeFactorsTestForThree() {
        PrimeFactors primeFactors = new PrimeFactors();

        ArrayList<Integer> result = primeFactors.generate(3);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(3);

        assertEquals(expected, result);
    }

    @Test
    public void primeFactorsTestForFour() {
        PrimeFactors primeFactors = new PrimeFactors();

        ArrayList<Integer> result = primeFactors.generate(4);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(2);

        assertEquals(expected, result);
    }

    @Test
    public void primeFactorsTestForFive() {
        PrimeFactors primeFactors = new PrimeFactors();

        ArrayList<Integer> result = primeFactors.generate(5);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(5);

        assertEquals(expected, result);
    }

    @Test
    public void primeFactorsTestForSix() {
        PrimeFactors primeFactors = new PrimeFactors();

        ArrayList<Integer> result = primeFactors.generate(6);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2, 3));

        assertEquals(expected, result);
    }

    @Test
    public void primeFactorsTestForSeven() {
        PrimeFactors primeFactors = new PrimeFactors();

        ArrayList<Integer> result = primeFactors.generate(7);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(7);

        assertEquals(expected, result);
    }

    @Test
    public void primeFactorsTestForEight() {
        PrimeFactors primeFactors = new PrimeFactors();

        ArrayList<Integer> result = primeFactors.generate(8);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(2);

        assertEquals(expected, result);
    }

    @Test
    public void primeFactorsTestForNine() {
        PrimeFactors primeFactors = new PrimeFactors();

        ArrayList<Integer> result = primeFactors.generate(9);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(3);

        assertEquals(expected, result);
    }

    @Test
    public void primeFactorsTestForFourThousandSixHundredTwenty() {
        PrimeFactors primeFactors = new PrimeFactors();
        
        ArrayList<Integer> result = primeFactors.generate(4620);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2, 3, 5, 7, 11));

        assertEquals(expected, result);
    }
}
