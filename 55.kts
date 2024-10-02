val s = Solution()
println(s.canJump(intArrayOf(3,2,1,0,4)))
println(s.canJump(intArrayOf(2,3,1,1,4)))

class Solution {
    fun canJump(nums: IntArray): Boolean {
        var furthestVisited = 0
        val reached = ArrayDeque(listOf(0))
        while (reached.isNotEmpty()) {
            val at = reached.removeLast()
            if (at == nums.size - 1) return true
            val maxJump = nums[at]
            for (to in Math.max(at + 1, furthestVisited)..at + maxJump) {
                if (to < nums.size) {
                    furthestVisited = to
                    reached.addLast(to)
                }
            }
        }
        return false
    }
}
