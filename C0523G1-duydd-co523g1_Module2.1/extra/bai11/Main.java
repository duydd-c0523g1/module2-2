package extra.bai11;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import static extra.bai11.GeneratePrimeWithQueue.primeNumbersWithQueue;
import static extra.bai11.GeneratePrimeWithStack.primeNumbersWithStack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert a number: ");
        int n = scanner.nextInt();
        Stack<Integer> primeStack = primeNumbersWithStack(n);
        System.out.println("Prime numbers with Stack: ");
        while (!primeStack.isEmpty()) {
            System.out.print(primeStack.pop() + " ");
        }
        System.out.println();
        Queue<Integer> primeQueue = primeNumbersWithQueue(n);
        System.out.println("Prime numbers with Queue:");
        while (!primeQueue.isEmpty()) {
            System.out.print(primeQueue.poll() + " ");
        }
    }
}
