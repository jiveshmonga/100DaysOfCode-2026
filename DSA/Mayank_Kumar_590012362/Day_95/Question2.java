class Solution {
    public int festival(int t, int[] d, int[] h) {
        int[] a = new int[t + 1];

        for (int i = 0; i < d.length; i++) {
            for (int j = t; j >= d[i]; j--) {
                a[j] = Math.max(a[j], a[j - d[i]] + h[i]);
            }
        }

        return a[t];
    }
}