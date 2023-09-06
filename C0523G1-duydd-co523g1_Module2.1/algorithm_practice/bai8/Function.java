package algorithm_practice.bai8;

import java.util.LinkedList;
import java.util.List;

public class Function {
    public static boolean bai8Function(int[] arr1, int[] arr2) {
        int tempIndex = 0;
        List<Integer> tempList = new LinkedList<>();
        for (Integer num : arr2) {
            tempList.add(num);
        }
        while (tempIndex < arr1.length) {
            for (int i = 0; i < tempList.size(); i++) {
                if (tempList.get(i) == arr1[tempIndex]) {
                    tempList.remove(tempList.get(i));
                    tempIndex++;
                }
            }
        }
        return tempList.isEmpty();
    }
}
