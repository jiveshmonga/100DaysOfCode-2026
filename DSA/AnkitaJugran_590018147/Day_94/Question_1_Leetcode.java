class Solution {
    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        System.out.println(obj.divisorGame(2)); // true
        System.out.println(obj.divisorGame(3)); // false
        System.out.println(obj.divisorGame(4)); // true
    }
}