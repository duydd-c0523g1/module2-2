package extra.bai3.bai3_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a number from 1 to 9");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println("The index of number " + number + " is "
                + IntegerArray.findExistence(array, number));
    }
}
