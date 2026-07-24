public class SumArray {
    public static int sumArray(int[] arr) {
        int sum = 0;

        for (int num : arr) {
            sum += num;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 2, 9, 1};

        int result = sumArray(arr);
        System.out.println("Sum = " + result);
    }
}