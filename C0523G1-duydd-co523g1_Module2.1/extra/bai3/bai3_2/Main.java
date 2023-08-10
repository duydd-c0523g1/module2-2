package extra.bai3.bai3_2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input array length");
        int arrayLength = Integer.parseInt(scanner.nextLine());
        System.out.println("Array: " + Arrays.toString(CreateArray.createArray(arrayLength)));
    }
}
