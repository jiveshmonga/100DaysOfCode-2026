import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // Sort balloons by their end coordinate (xend)
        Arrays.sort(points, (a, b) -> Long.compare(a[1], b[1]));
        // Using Long compare to safely handle values near Integer.MIN/MAX_VALUE

        int arrows = 1;
        long arrowPos = points[0][1]; // position of current arrow = end of first balloon

        for (int i = 1; i < points.length; i++) {
            int start = points[i][0];
            int end = points[i][1];

            if (start > arrowPos) {
                // Current arrow can't reach this balloon — need a new one
                arrows++;
                arrowPos = end;
            }
            // else: this balloon is already burst by the current arrow, do nothing
        }

        return arrows;
    }
}
