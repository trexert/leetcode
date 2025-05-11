val s = Solution()
println(s.findMin(intArrayOf(4,5,6,7,0,1,2)))
println(s.findMin(intArrayOf(3,4,5,1,2)))
println(s.findMin(intArrayOf(11,13,15,17)))
println(s.findMin(intArrayOf(11,13,15,17,4)))

class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 2
        val discontinuity = nums.last()
        while (left < right) {
            val mid = (left + right) / 2
            if (nums[mid] < discontinuity) {
                right = mid
            } else {
                // elements unique, so must be >, not equal
                left = mid + 1
            }
        }
        return minOf(nums[left], discontinuity)
    }
}