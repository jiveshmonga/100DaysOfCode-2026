public static int rob(int[] a) {
    int x = 0, y = 0;
    for (int n : a) {
        int z = Math.max(y, x + n);
        x = y; y = z;
    } return y;
}