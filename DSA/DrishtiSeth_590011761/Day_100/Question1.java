import java.util.*;

public class Main {

    static boolean canFinish(int[] piles, int h, long k) {
        long hours = 0;

        for (int bananas : piles) {
            hours += (bananas + k - 1) / k;

            if (hours > h) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int h = sc.nextInt();

        int[] piles = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            piles[i] = sc.nextInt();
            max = Math.max(max, piles[i]);
        }

        long low = 1;
        long high = max;

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (canFinish(piles, h, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low);
    }
}
