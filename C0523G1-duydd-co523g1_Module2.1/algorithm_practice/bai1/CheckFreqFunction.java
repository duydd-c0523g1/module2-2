package algorithm_practice.bai1;

import java.util.HashMap;
import java.util.Map;

public class CheckFreqFunction {
    public static boolean checkFreq(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int firstFreq = -1;
        for (int freq : freqMap.values()) {
            if (firstFreq == -1) {
                firstFreq = freq;
            } else {
                if (freq != firstFreq) {
                    return false;
                }
            }
        }
        return true;
    }
}