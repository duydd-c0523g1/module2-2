package extra.bai2.b2_2;

public class LCM {
    public static int leastCommonMultiple(int num1, int num2) {
        return (num1 * num2) / GCD.greatestCommonDivisor(num1, num2);
    }
}
