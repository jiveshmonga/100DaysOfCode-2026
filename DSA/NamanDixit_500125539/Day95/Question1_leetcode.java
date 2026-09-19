
class Question1_leetcode {

    public int tribonacci(int n) {

        // T0 = 0
        int a = 0;

        // T1 = 1
        int b = 1;

        // T2 = 1
        int c = 1;

        // Handle n = 0
        if (n == 0) {
            return a;
        }

        // Handle n = 1
        if (n == 1) {
            return b;
        }

        // Handle n = 2
        if (n == 2) {
            return c;
        }

        // Calculate from T3 to Tn
        for (int i = 3; i <= n; i++) {

            // Add previous three numbers
            int next = a + b + c;

            // Move forward
            a = b;
            b = c;
            c = next;
        }

        // Return Tn
        return c;
    }
}
