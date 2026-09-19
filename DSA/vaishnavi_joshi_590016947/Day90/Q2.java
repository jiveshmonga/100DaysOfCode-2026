import java.util.Arrays;

class Solution {
    public int videoStitching(int[][] clips, int time) {
        
        // Sort clips by starting time
        Arrays.sort(clips, (a, b) -> Integer.compare(a[0], b[0]));
        
        int count = 0;
        int currentEnd = 0;
        int i = 0;
        
        while (currentEnd < time) {
            
            int farthest = currentEnd;
            
            // Find the clip that extends coverage the farthest
            while (i < clips.length && clips[i][0] <= currentEnd) {
                farthest = Math.max(farthest, clips[i][1]);
                i++;
            }
            
            // Cannot extend coverage
            if (farthest == currentEnd) {
                return -1;
            }
            
            // Use one clip
            count++;
            currentEnd = farthest;
        }
        
        return count;
    }
}