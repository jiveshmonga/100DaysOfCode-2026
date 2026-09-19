import java.util.HashMap;

class Solution {
    public int firstInvalidRecord(String[][] deliveries) {

        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < deliveries.length; i++) {

            String vendor = deliveries[i][0];
            String lot = deliveries[i][1];
            String cert = deliveries[i][2];

            // Create a unique key for vendor + lot
            String key = vendor + "#" + lot;

            // If this vendor-lot pair was seen before
            if (map.containsKey(key)) {

                // Check certification code
                if (!map.get(key).equals(cert)) {
                    return i;
                }

            } else {
                // First time seeing this vendor-lot pair
                map.put(key, cert);
            }
        }

        return -1;
    }
}