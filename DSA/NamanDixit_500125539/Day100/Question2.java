import java.util.Scanner;

public class Question2 {

    public static void main(String[] args) {

        // Create Scanner object
        // This is used to take input from the user
        Scanner sc = new Scanner(System.in);

        // Take the number of days
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        // Create an array to store temperatures
        int[] temperatures = new int[n];

        // Take temperatures from the user
        System.out.println("Enter temperatures:");

        for (int i = 0; i < n; i++) {

            // Store the temperature of each day
            temperatures[i] = sc.nextInt();
        }

        // Create an array to store the answer
        //
        // answer[i] = number of days we need to wait
        //              for a warmer temperature
        int[] answer = new int[n];


        // Go through every day
        for (int i = 0; i < n; i++) {

            // Look at all the days after day i
            for (int j = i + 1; j < n; j++) {

                // Check if the temperature is warmer
                if (temperatures[j] > temperatures[i]) {

                    // Number of days we waited
                    answer[i] = j - i;

                    // We found the FIRST warmer day
                    // so stop searching
                    break;
                }
            }
        }


        // Print the answer
        System.out.println("Days until warmer temperature:");

        for (int i = 0; i < n; i++) {

            System.out.print(answer[i] + " ");
        }

        // Move to next line
        System.out.println();

        // Close Scanner
        sc.close();
    }
}