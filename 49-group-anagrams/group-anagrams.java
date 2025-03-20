class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();

        for (String s: strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String t = new String(c);

            hm.computeIfAbsent(t, k -> new ArrayList<>()).add(s);
        }

        List<List<String>> res = new ArrayList<>();

        for (List<String> ls : hm.values()) {
            res.add(ls);
        }

        return res;
    }
}