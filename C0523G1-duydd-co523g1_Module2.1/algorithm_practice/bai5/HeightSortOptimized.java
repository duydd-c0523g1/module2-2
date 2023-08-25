package algorithm_practice.bai5;

import java.util.ArrayList;
import java.util.List;

public class HeightSortOptimized {
    public static void main(String[] args) {
        int[] arr = {-1, 150, 190, 170, -1, -1, 160, 180};
        List<Integer> result = sortByHeight(arr);
        System.out.println(result);
    }
    public static List<Integer> sortByHeight(int[] arr) {
        List<Integer> result = new ArrayList<>();
        List<Integer> tempArr = new ArrayList<>();
        for (int value : arr) {
            if (value != -1) {
                tempArr.add(value);
            }
        }
        tempArr.sort(Integer::compareTo);
        int tempIndex = 0;
        for (int value : arr) {
            result.add(value == -1 ? -1 : tempArr.get(tempIndex++));
        }
        return result;
    }
}
