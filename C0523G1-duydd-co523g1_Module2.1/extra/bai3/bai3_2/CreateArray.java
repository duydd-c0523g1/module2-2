package extra.bai3.bai3_2;

import java.util.Scanner;

public class CreateArray {
    public static int[] createArray(int arrayLength) {
        int[] array = new int[arrayLength];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arrayLength; i++) {
            System.out.println("Input a number at index " + i);
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        return array;
    }
}
