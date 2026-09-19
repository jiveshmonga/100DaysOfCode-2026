import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        int actualSum = 0;

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            actualSum += arr[i];
        }

        int expectedSum = n * (n + 1) / 2;

        int missingNumber = expectedSum - actualSum;

        System.out.println(missingNumber);

        sc.close();
    }
}
