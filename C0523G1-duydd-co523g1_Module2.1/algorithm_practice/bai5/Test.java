package algorithm_practice.bai5;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] heights = {150, -1, 170, 160, 180, -1, 165};
        Arrays.stream(heights).boxed().filter(h -> h != -1).sorted().forEachOrdered(h -> System.out.print(h + " "));
//        Arrays.stream(heights)
//                .boxed()
//                .filter(h -> h != -1)
//                .sorted()
//                .forEachOrdered(h -> System.out.print(h + " "));
    }
}
