package algorithm_practice.bai6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String str = "abdceffecdba";
        System.out.println(Arrays.toString(findCharFreq(str)));
    }

    public static char[] findCharFreq(String string) {
        char[] chars = string.toCharArray();
        List<Character> result = new ArrayList<>();
        List<Character> characters1 = new ArrayList<>();
        List<Character> characters2 = characters1;
        for (char c : chars) {
            characters1.add(c);
        }
        for (int i = 0; i < characters1.size(); characters1.remove(characters1.get(i))) {
            for (int j = i + 1; j < characters1.size(); j++) {
                if (characters1.get(i) == characters2.get(j)) {
                    result.add(characters1.get(i));
                }
            }
        }
        char[] resultArr = new char[result.size()];
        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }
}
