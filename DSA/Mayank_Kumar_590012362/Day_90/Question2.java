class Solution {
    public int videoStitching(int[][] c, int t) {
        Arrays.sort(c, (a, b) -> a[0] - b[0]);
        int n = c.length, i = 0, r = 0, e = 0, ans = 0;
        while (r < t) {
            while (i < n && c[i][0] <= r)
                e = Math.max(e, c[i++][1]);
            if (e == r) return -1;
            r = e; ans++;
        }
        return ans;
    }
}