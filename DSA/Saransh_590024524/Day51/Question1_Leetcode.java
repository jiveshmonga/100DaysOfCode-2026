import java.util.HashMap;

public class Question1_Leetcode {
    
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int x : nums) {
            if (x % 2 == 0) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        }

        int answer = -1;
        int maxFreq = 0;

        for (int x : map.keySet()) {

            int freq = map.get(x);

            if (freq > maxFreq) {
                maxFreq = freq;
                answer = x;
            }
            else if (freq == maxFreq && x < answer) {
                answer = x;
            }
        }

        return answer;
    }
}
