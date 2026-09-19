import java.util.*;

public class Question2 {

    static int videoStitching(int[][] clips, int time) {
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
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] clips = new int[n][2];

        for (int i = 0; i < n; i++) {
            clips[i][0] = sc.nextInt();
            clips[i][1] = sc.nextInt();
        }

        int time = sc.nextInt();

        System.out.println(videoStitching(clips, time));
        sc.close();
    }
}