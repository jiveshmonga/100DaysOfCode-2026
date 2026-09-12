import java.util.*;
class Question2 {
 public static int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);
        int count = 0;
        int currentEnd = 0;
        int i = 0;
        while (currentEnd < time) {
            int farthest = currentEnd;
            while (i < clips.length && clips[i][0] <= currentEnd) {
                farthest = Math.max(farthest, clips[i][1]);
                i++;
            }
            if (farthest == currentEnd) {
                return -1;
            }
            currentEnd = farthest;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] clips = {
            {0, 2},
            {1, 6},
            {4, 8},
            {7, 10},
            {9, 12}
        };
        int time = 10;
        System.out.println(videoStitching(clips, time));
    }
}