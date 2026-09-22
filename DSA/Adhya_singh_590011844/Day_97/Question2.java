import java.util.*;

public class Main {

    static long maxEnergy(int[] energy) {
        int n = energy.length;

        long prev2 = energy[0];

        long prev1 = (long) energy[0] + energy[1];

        if (n == 1) {
            return prev2;
        }

        for (int i = 2; i < n; i++) {

            long current = energy[i] + Math.max(prev1, prev2);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] energy = new int[n];

        for (int i = 0; i < n; i++) {
            energy[i] = sc.nextInt();
        }

        System.out.println(maxEnergy(energy));

        sc.close();
    }
}