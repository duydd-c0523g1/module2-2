package algorithm_practice.bai5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HeightSort2 {
    public static void main(String[] args) {
        int[] arr = {-1, 150, 190, 170, -1, -1, 160, 180};
        List<Integer> result = sortByHeight(arr);
        System.out.println(result);
    }

    public static List<Integer> sortByHeight(int[] a) {
        List<Integer> t = new ArrayList<>();
        for (int n : a)
            if (n != -1) t.add(n);
        t.sort(null);
//               If the specified comparator is null then
//                all elements in this list must implement
//                  the Comparable interface and the
//                   elements' natural ordering should be used.
        List<Integer> r = new ArrayList<>();
        for (int n : a)
            r.add(n == -1 ? -1 : t.remove(0));
        return r;
    }
}
