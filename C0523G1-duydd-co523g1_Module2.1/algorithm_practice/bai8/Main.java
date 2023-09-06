package algorithm_practice.bai8;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 5, 2, 1};
        int[] arr2 = {1, 2, 3};
        boolean result  = Function.bai8Function(arr1, arr2);
        if (result) {
            System.out.println("OK");
        } else {
            System.out.println(" not ok");
        }
    }
}
