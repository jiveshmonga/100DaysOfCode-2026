class Solution {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length;
        int[] a = new int[n];
        int[] s = new int[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            while (k > 0 && t[i] > t[s[k - 1]]) {
                int j = s[--k];
                a[j] = i - j;
            } s[k++] = i;
        } return a;
    }
}