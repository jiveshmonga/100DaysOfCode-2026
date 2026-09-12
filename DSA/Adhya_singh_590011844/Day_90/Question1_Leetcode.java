import java.util.*;

public class Main {

    static int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        long arrowPosition = points[0][1];

        for (int i = 1; i < points.length; i++) {

            if (points[i][0] > arrowPosition) {
                arrows++;

                arrowPosition = points[i][1];
            }
        }

        return arrows;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] points = new int[n][2];

        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        System.out.println(findMinArrowShots(points));

        sc.close();
    }
}