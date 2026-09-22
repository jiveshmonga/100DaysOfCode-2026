class Solution {
    public int videoStitching(int[][] clips, int time) {

        Arrays.sort(clips, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int count = 0;
        int currentEnd = 0;
        int farthest = 0;
        int i = 0;

        while (currentEnd < time) {

            while (i < clips.length && clips[i][0] <= currentEnd) {
                farthest = Math.max(farthest, clips[i][1]);
                i++;
            }

            if (farthest == currentEnd) {
                return -1;
            }
            count++;
            currentEnd = farthest;
        }

        return count;
    }
}