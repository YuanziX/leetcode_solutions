
class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var l = 0
        var r = numbers.size - 1
        while (l < r) {
            val sum = 
            if (numbers[l] + numbers[r] < target) {
                l++
            } else if (numbers[l] + numbers[r] > target) {
                r--
            }
            else {
                return intArrayOf(l + 1, r + 1)
            }
        }
        return intArrayOf()
    }
}
