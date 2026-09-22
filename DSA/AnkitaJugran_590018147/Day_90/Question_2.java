import java.util.Arrays;

public class Video_Stiching {
    
    public static int videoStitching(int[][] clips, int time) {

        // Sort clips according to starting time
        Arrays.sort(clips, (a, b) -> Integer.compare(a[0], b[0]));

        int clipsUsed = 0;
        int currentEnd = 0;
        int farthest = 0;
        int i = 0;

        while (currentEnd < time) {

            // Find the clip that starts at or before currentEnd
            while (i < clips.length && clips[i][0] <= currentEnd) {
                farthest = Math.max(farthest, clips[i][1]);
                i++;
            }

            // Cannot extend the coverage
            if (farthest == currentEnd) {
                return -1;
            }

            // Use one clip
            clipsUsed++;

            // Extend our covered time
            currentEnd = farthest;
        }

        return clipsUsed;
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

        int result = videoStitching(clips, time);

        System.out.println("Minimum clips required: " + result);
    }
}
