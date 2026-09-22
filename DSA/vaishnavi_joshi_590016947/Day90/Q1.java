import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        
        // Sort balloons by their ending point
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int arrows = 1;
        int arrowPosition = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            
            // Current balloon starts after the arrow position
            if (points[i][0] > arrowPosition) {
                arrows++;
                arrowPosition = points[i][1];
            }
        }
        
        return arrows;
    }
}