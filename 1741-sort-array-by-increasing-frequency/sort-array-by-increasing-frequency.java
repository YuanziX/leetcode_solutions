import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(arr, (a, b) -> {
            int fa = freq.get(a), fb = freq.get(b);
            if (fa == fb) return b - a;
            return fa - fb;
        });

        return Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
    }
}
