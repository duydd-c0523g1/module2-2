package algorithm_practice.bai6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String str = "abcbdcef";
        System.out.println(findCharFreq(str));
    }

    public static char[] findCharFreq(String string) {
        int tempIndex = 1;
        char[] chars = string.toCharArray();
        List<Character> result = new ArrayList<>();
        List<Character> characters = new ArrayList<>();
        for (char c : chars) {
            characters.add(c);
        }
        for (int i = 0; i < characters.size(); i++) {
            if (characters.get(i) == characters.get(tempIndex)) {
                result.add(characters.get(i));
                characters.remove(characters.get(i));
                characters.remove(characters.get(tempIndex));
            }
        }
        char[] charResult = new char[result.size()];
        for (int i = 0; i < result.size(); i++) {
            charResult[i] = result.get(i);
        }
        return charResult;
    }
}
