package algorithm_practice.bai7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeSorting {

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static int[] extractPrimes(int[][] matrix) {
        List<Integer> primeList = new ArrayList<>();

        for (int[] row : matrix) {
            for (int num : row) {
                if (isPrime(num)) {
                    primeList.add(num);
                }
            }
        }
        int[] primesArray = new int[primeList.size()];
        for (int i = 0; i < primeList.size(); i++) {
            primesArray[i] = primeList.get(i);
        }
        return primesArray;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 8, 43},
                {9, 4, 11, 7},
                {11, 6, 4, 0},
                {1, 2, 6, 51}
        };

        int[] primes = extractPrimes(matrix);
        Arrays.sort(primes);

        System.out.print("[");
        for (int i = 0; i < primes.length; i++) {
            System.out.print(primes[i]);
            if (i < primes.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
