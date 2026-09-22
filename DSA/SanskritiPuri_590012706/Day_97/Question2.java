class Solution {
    public int maxEnergy(int[] energy) {
        int n = energy.length;

        int prev2 = energy[0];
        int prev1 = Math.max(energy[0], energy[0] + energy[1]);

        for (int i = 2; i < n; i++) {
            int current = energy[i] + Math.max(prev1, prev2);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
