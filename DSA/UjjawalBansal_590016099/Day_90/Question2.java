import java.util.Arrays;
import java.util.Scanner;

public class Question2 {
    
    public static int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });
        
        int c = 0;
        int currentEnd = 0;
        int i = 0;
        int n = clips.length;
        
        while (currentEnd < time) {
            int last = currentEnd;
            
            while (i < n && clips[i][0] <= currentEnd) {
                last = Math.max(last, clips[i][1]);
                i++;
            }
            
            if (last == currentEnd) {
                return -1;
            }
            
            currentEnd = last;
            c++;
        }
        
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of clips: ");
        int n = sc.nextInt();
        
        int[][] clips = new int[n][2];
        System.out.println("Enter the start and end times for each clip:");
        for (int i = 0; i < n; i++) {
            clips[i][0] = sc.nextInt();
            clips[i][1] = sc.nextInt();
        }
        
        System.out.print("Enter the total time to cover: ");
        int time = sc.nextInt();
        
        int result = videoStitching(clips, time);
        System.out.println("Minimum Clips: " + result);
        
        sc.close();
    }
}