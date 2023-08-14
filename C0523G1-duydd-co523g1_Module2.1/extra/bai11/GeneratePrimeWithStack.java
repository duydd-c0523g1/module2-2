package extra.bai11;

import java.util.Stack;

import static extra.bai11.NumberCheck.isPrime;

public class GeneratePrimeWithStack {
    public static Stack<Integer> primeNumbersUsingStack(int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) {
                stack.push(i);
            }
        }
        return stack;
    }
}
