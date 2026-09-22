import java.util.*;

public class Question2 {
    public static int maxEnergy(int n, int[] energy) {
        int twoBack = energy[0];
        int oneBack = energy[0] + energy[1];

        for (int i = 2; i < n; i++) {
            int current = energy[i] + Math.max(oneBack, twoBack);
            twoBack = oneBack;
            oneBack = current;
        }
        return oneBack;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of floors: ");
        int n = sc.nextInt();
        int[] energy = new int[n];

        System.out.println("Enter " + n + " energy values:");

        for (int i = 0; i < n; i++) {
            energy[i] = sc.nextInt();
        }

        System.out.println("Maximum total energy = " + maxEnergy(n, energy));
        sc.close();
    }
}