package extra.bai11;

import java.util.LinkedList;
import java.util.Queue;

import static extra.bai11.NumberCheck.isPrime;

public class GeneratePrimeWithQueue {
    public static Queue<Integer> primeNumbersUsingQueue(int n) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) {
                queue.offer(i);
            }
        }
        return queue;
    }
}
