class Solution {
    public int maxEnergy(int[] e) {
        int n = e.length;
        if (n == 1) return e[0];

        int a = e[0], b = Math.max(e[0], e[1]);

        for (int i = 2; i < n; i++) {
            int c = Math.max(b, a + e[i]);
            a = b;
            b = c;
        }

        return b;
    }
}