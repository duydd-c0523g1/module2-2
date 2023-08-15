package algorithm_practice.bai2;

public class CharacterInCommon {
    public static int checkCharInCommon(String str1, String str2) {
        int count = 0;
        char[] arr1 = str1.trim().toCharArray();
        char[] arr2 = str2.trim().toCharArray();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
