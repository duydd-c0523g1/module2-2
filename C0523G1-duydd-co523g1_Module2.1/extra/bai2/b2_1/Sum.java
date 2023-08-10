package extra.bai2.b2_1;
public class Sum {
    public static int sum(int number) {
        int sum = 0;
        if (number > 0) {
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    sum += i;
                }
            }
        } else {
            System.out.println("Input number must be bigger than 0");
        }
        return sum;
    }
}
