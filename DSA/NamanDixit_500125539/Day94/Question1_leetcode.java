class Question1_leetcode {
    public boolean divisorGame(int n) {

        // If n is even, Alice can win
        if (n % 2 == 0) {
            return true;
        }

        // If n is odd, Alice loses
        else {
            return false;
        }
    }

}