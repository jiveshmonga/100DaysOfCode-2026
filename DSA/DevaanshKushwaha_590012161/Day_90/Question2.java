import java.util.Arrays;

class Solution {
    public int videoStitching(int[][] clips, int time) {
        // farthest[i] = max end time reachable using a clip that starts at position i
        int[] farthest = new int[time];

        for (int[] clip : clips) {
            int start = clip[0], end = clip[1];
            if (start < time) {
                farthest[start] = Math.max(farthest[start], end);
            }
        }

        int clipsUsed = 0;
        int curEnd = 0;      // end of the current clip's coverage
        int nextEnd = 0;     // farthest reachable using one more clip
        int i = 0;

        while (curEnd < time) {
            // While within current clip's range, look for the best next clip
            while (i <= curEnd) {
                nextEnd = Math.max(nextEnd, farthest[i]);
                i++;
            }

            if (nextEnd <= curEnd) {
                // Can't extend further — a gap exists, coverage impossible
                return -1;
            }

            clipsUsed++;
            curEnd = nextEnd;
        }

        return clipsUsed;
    }
}
