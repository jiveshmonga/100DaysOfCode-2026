public class Question1_Leetcode {
    public int climbStairs(int n) {
        int a = 1;
        int b = 1;
        for(int i = 2; i <= n; i++){
            int current = a+b;
            a = b;
            b = current;
        }
        return b;
    }
}