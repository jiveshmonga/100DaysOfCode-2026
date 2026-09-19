public class Question1_Leetcode {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1;
        int arrow = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > arrow) {
                count++;
                arrow = points[i][1];
            }
        }
        return count;
    }
}