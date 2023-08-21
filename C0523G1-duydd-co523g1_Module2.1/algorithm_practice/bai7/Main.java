package algorithm_practice.bai7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 8, 43}, {9, 4, 11, 7}, {11, 6, 4, 0}, {1, 2, 6, 51}};
        System.out.println(Arrays.toString(sortArray(arr)));
    }

    public static int[] sortArray(int[][] arr) {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> prime = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                numbers.add(arr[i][j]);
            }
        }
        for (Integer num : numbers) {
            if (num > 1) {
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i != 0) {
                        prime.add(num);
                    }
                }
            }
        }
        prime.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int[] primeArr = new int[prime.size()];
        for (int i = 0; i < prime.size(); i++) {
            primeArr[i] = prime.get(i);
        }
        return primeArr;
    }
}
