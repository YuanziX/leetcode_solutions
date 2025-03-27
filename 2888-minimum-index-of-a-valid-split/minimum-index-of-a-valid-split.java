class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int dom = getDom(nums);
        if (dom == -1) return -1;

        int left = 0, right = 0;
        for (int i: nums) {
            if (i == dom) right++;
        }

        int c = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (2 * left > i && 2 * right > n - i) {
                return i - 1;
            }
    
            if (nums.get(i) == dom) {
                left++;
                right--;
            }
        }

        return -1;
    }

    public int getDom(List<Integer> arr) {
        int cand = -1, count = 0;
        for (int n: arr) {
            if (count == 0) {
                cand = n;
                count = 1;
            } else if (n == cand) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int i : arr) {
            if (i == cand) count++;
        }

        return count > arr.size() / 2 ? cand : -1;
    }
}