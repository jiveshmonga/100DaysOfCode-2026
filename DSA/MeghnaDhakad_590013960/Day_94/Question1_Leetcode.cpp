class Solution {
public:
    bool divisorGame(int n) {
        // Alice wins if she starts with an even number
        return n % 2 == 0;
    }
};