
class SR{
    public static int maxHappiness(int T, int[] duration, int[] happiness) {
        int n = duration.length;
        int[] dp = new int[T + 1];
        for (int i = 0; i < n; i++) {
            for (int t = T; t >= duration[i]; t--) {
                dp[t] = Math.max(
                    dp[t],
                    happiness[i] + dp[t - duration[i]]
                );
            }
        }
        return dp[T];
    }
    public static void main(String[] args) {
        int T = 7;
        int[] duration = {2, 3, 4, 5};
        int[] happiness = {4, 5, 7, 8};
        int answer = maxHappiness(T, duration, happiness);
        System.out.println("Maximum Happiness:" + answer);
    }
}