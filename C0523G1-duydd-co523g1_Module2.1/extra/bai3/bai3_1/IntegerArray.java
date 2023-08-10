package extra.bai3.bai3_1;

public class IntegerArray {
    public static int findExistence(int[] array, int arrayNumber) {
        int indexOfNumber = 0;
        for (int i = 0; i < array.length; i++) {
            if (arrayNumber == array[i]) {
                indexOfNumber = i;
            }
        }
        return indexOfNumber;
    }
}
