
import java.util.Arrays;

public class Question1_leetcode {

    // Function to find the minimum number of arrows
    static int findMinArrowShots(int[][] points) {

        // If there are no balloons,
        // we don't need any arrows
        if (points.length == 0) {
            return 0;
        }

        // Sort the balloons according to their END point
        //
        // The balloon with the smallest ending point
        // will come first.
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        // We need at least one arrow
        int arrows = 1;

        // Shoot the first arrow at the end of
        // the first balloon
        int arrowPosition = points[0][1];

        // Check the remaining balloons
        for (int i = 1; i < points.length; i++) {

            // Check if the current balloon starts
            // AFTER our arrow position
            if (points[i][0] > arrowPosition) {

                // Our current arrow cannot burst this balloon
                // So we need another arrow
                arrows++;

                // Shoot the new arrow at the end
                // of the current balloon
                arrowPosition = points[i][1];
            }

            // If points[i][0] <= arrowPosition,
            // the current arrow can burst this balloon,
            // so we don't need another arrow.
        }

        // Return the total number of arrows
        return arrows;
    }

}
