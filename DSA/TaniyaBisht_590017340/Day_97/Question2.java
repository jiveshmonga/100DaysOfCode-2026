
class ET{
    public static int maxEnergy(int N, int[] energy){
        int[] dp = new int[N];
        dp[0] = energy[0];
        if (N > 1) {
            dp[1] = energy[1];
        }
        for (int i = 2; i < N; i++) {
            dp[i] = energy[i] + Math.max(dp[i - 1], dp[i - 2]);
        }
        return dp[N - 1];
    }
    public static void main(String[] args) {
        int N = 6;
        int[] energy = {5, 10, 20, 15, 25, 30};
        System.out.println(maxEnergy(N, energy));
    }
}