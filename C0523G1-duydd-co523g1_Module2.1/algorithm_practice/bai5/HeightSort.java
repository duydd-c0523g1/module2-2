package algorithm_practice.bai5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HeightSort {
    public static void main(String[] args) {
        int[] arr = {-1, 150, 190, 170, -1, -1, 160, 180};
        List<Integer> result = sortByHeight(arr);
        System.out.println(result);
    }

    public static List<Integer> sortByHeight(int[] arr) {
        List<Integer> tempArr = new ArrayList<>();
        for (int value : arr) {
            if (value != -1) {
                tempArr.add(value);
            }
        }
        tempArr.sort(Comparator.naturalOrder());
        List<Integer> result = new ArrayList<>();
        int tempIndex = 0;
        for (int value : arr) {
            if (value == -1) {
                result.add(-1);
            } else {
                result.add(tempArr.get(tempIndex));
                tempIndex++;
            }
        }
        return result;
    }
}
