package prime_numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel Zeger
 * @implNote irm-example
 * @since 09/04/2021
 */
public class PrimeNumbersService {

    PrimeNumbersService() {

    }

    public static int[] getPrimeNumbers(int[] numbers) {
        List<Integer> primeNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (isPrime(number)) {
                primeNumbers.add(number);
            }
        }
        return primeNumbers.stream().mapToInt(i -> i).toArray();
    }

    private static boolean isPrime(int number) {
        int remainder;
        if (number == 0 || number == 1) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
             remainder = number % 2;
             if (remainder == 0) {
                 return false;
             }
        }
        return true;
    }
}
