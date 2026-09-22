import java.util.*;
public class Question2 {
    public static int minClips(int[][] clips, int time) {

        Arrays.sort(clips, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 0, i = 0, end = 0;
        while (end < time) {
            int farthest = end;
            while (i < clips.length && clips[i][0] <= end){
                farthest = Math.max(farthest, clips[i++][1]);
            }
            if (farthest == end) return -1;
            end = farthest;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of clips: ");
        int n = sc.nextInt();
    
        int[][] clips = new int[n][2];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter start and end time for clip " + (i + 1) + ": ");
            clips[i][0] = sc.nextInt();
            clips[i][1] = sc.nextInt();
        }
        System.out.print("Enter total time: ");
        int time = sc.nextInt();

        System.out.println("Minimum clips required: " + minClips(clips, time));
        sc.close();
    }
}