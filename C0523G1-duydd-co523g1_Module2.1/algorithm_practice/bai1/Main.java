//Bài 1:
//Level: Khó
//Yêu cầu:
//Cho một mảng số nguyên Hãy kiểm tra xem tần số xuất hiện của tất cả các số nguyên trong mảng có bằng nhau hay không
//Input: 1 chuỗi chứa dãy số nguyên, mỗi số cách nhau bởi 1 dấu “,”
//Output: 1 giá trị Boolean
package algorithm_practice.bai1;

public class Main {
    public static void main(String[] args) {
        int[] array = {1,1,2,3,3,2};
        boolean result = CheckFreqFunction.checkFrequency(array);
            if (result) {
                System.out.println("Mảng có tần số xuất hiện các phần tử bằng nhau");
            } else {
                System.out.println("Mảng có tần số xuất hiện các phần tử không bằng nhau");
            }
    }
}
