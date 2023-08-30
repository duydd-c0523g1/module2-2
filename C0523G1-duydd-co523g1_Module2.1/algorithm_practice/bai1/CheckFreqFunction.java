package algorithm_practice.bai1;

import java.util.HashMap;
import java.util.Map;

public class CheckFreqFunction {
    public static boolean checkFrequency(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        int firstFreq = -1;
        for (int freq : frequencyMap.values()) {
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