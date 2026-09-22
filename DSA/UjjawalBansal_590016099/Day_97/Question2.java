import java.util.Scanner;

public class Question2 {
    public static int maxEnergy(int n, int[] energy) {
        if (n == 0) return 0;
        if (n == 1) return energy[0];
        
        int prev2 = energy[0];
        
        int prev1 = energy[0] + energy[1];
        
        for (int i = 2; i < n; i++) {
            int current = Math.max(prev1, prev2) + energy[i];
            
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of floors (N): ");
        int n = sc.nextInt();
        
        int[] energy = new int[n];
        System.out.print("Enter the " + n + " energy values: ");
        for (int i = 0; i < n; i++) {
            energy[i] = sc.nextInt();
        }
        
        int result = maxEnergy(n, energy);
        System.out.println("Output (Maximum Energy): " + result);
        sc.close();
    }
}