package extra.bai2.b2_2;

public class Main {
    public static void main(String[] args) {
        int num1 = 48;
        int num2 = 18;
        int gcd = GCD.greatestCommonDivisor(num1, num2);
        int lcm = LCM.leastCommonMultiple(num1, num2);
        System.out.println("Trung bình cộng của ước chung" +
                " lớn nhất và bội chung nhỏ nhất của " + num1 + " và "
                + num2 + " là: " + (gcd + lcm) / 2);
    }
}
