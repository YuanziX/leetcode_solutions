class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> hm = new HashMap<>();
        for (char c: jewels.toCharArray()) {
            hm.put(c, 0);
        }

        for (char c: stones.toCharArray()) {
            if (hm.containsKey(c)) {
                hm.put(c, hm.get(c) + 1);
            }
        }

        int sum = 0;
        for (Map.Entry<Character, Integer> m: hm.entrySet()) {
            sum += m.getValue();
        }
        return sum;
    }
}