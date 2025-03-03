class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.add(i);
        }

        for (k = nums.length - k; k > 0; k--) {
            pq.poll();
        }

        return pq.poll();
    }
}