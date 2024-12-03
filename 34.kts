class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val lower = binaryChopLower(nums, target)

        if (lower < 0 || nums[lower] != target) return intArrayOf(-1, -1)

        return intArrayOf(lower, binaryChopHigher(nums, target))
    }

    private fun binaryChopLower(nums: IntArray, target: Int): Int {
        var (min, max) = Pair(-1, nums.size - 1)
        while (max - min > 1) {
            val mid = (min + max + 1) / 2
            if (nums[mid] < target) {
                min = mid
            } else {
                max = mid
            }
        }
        return max
    }

    private fun binaryChopHigher(nums: IntArray, target: Int): Int {
        var (min, max) = Pair(0, nums.size)
        while (max - min > 1) {
            val mid = (min + max) / 2
            if (nums[mid] > target) {
                max = mid
            } else {
                min = mid
            }
        }
        return min
    }
}

val s = Solution()

println(s.searchRange(intArrayOf(5,7,7,8,8,10), 8).joinToString())
println(s.searchRange(intArrayOf(5,7,7,8,8,10), 6).joinToString())
println(s.searchRange(intArrayOf(), 6).joinToString())