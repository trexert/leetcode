import kotlin.math.abs

val s = Solution()
println(s.maxWidthRamp(intArrayOf(6,0,8,2,1,5)))
println(s.maxWidthRamp(intArrayOf(9,8,1,0,1,9,4,0,4,1)))

class Solution {
    fun maxWidthRamp(nums: IntArray): Int {
        val rampStarts = mutableListOf<Pair<Int, Int>>()
        var bestRamp = 0
        rampStarts.add(Pair(nums[0], 0))
        for ((i, num) in nums.drop(1).withIndex()) {
            if (num < rampStarts.last().first) {
                rampStarts.add(Pair(num, i + 1))
            } else {
                var indexOfRampStart = rampStarts.binarySearch(element = Pair(num, i + 1), Comparator { (h1, _), (h2, _) -> -h1.compareTo(h2) })
                if (indexOfRampStart < 0) indexOfRampStart = -indexOfRampStart - 1
                val rampWidth = i + 1 - rampStarts[indexOfRampStart].second
                if (rampWidth > bestRamp) {
                    bestRamp = rampWidth
                }
            }
        }
        return bestRamp
    }
}
