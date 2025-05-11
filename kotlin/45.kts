val s = Solution()
println(s.jump(intArrayOf(2,3,1,1,4)))
println(s.jump(intArrayOf(2,3,0,1,4)))

class Solution {
    fun jump(nums: IntArray): Int {
        val queue = ArrayDeque<Pair<Int, Int>>(1000)
        queue.addLast(Pair(0, 0))
        var furthestReached = 0

        while (queue.first().first < nums.size - 1) {
            val (currentPos, currentSteps) = queue.removeFirst()
            val maxJump = nums[currentPos]
            for (i in furthestReached + 1..currentPos + maxJump) {
                queue.addLast(Pair(i, currentSteps + 1))
            }
            furthestReached = furthestReached.coerceAtLeast(currentPos + maxJump)
        }

        return queue.first().second
    }
}
