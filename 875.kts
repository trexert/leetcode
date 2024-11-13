import kotlin.random.Random
import kotlin.random.nextInt

val s = Solution()

println(s.minEatingSpeed(intArrayOf(3,6,7,11), 8))
println(s.minEatingSpeed(intArrayOf(30,11,23,4,20), 5))
println(s.minEatingSpeed(intArrayOf(30,11,23,4,20), 6))
val rng = Random.Default
println(s.minEatingSpeed(IntArray(10000) {_ -> rng.nextInt(1_000_000_000) }, rng.nextInt(1_000_000_000)))

class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        return binaryChop(1, piles.max()) { k -> canEatBananas(piles, h, k) }
    }

    private fun binaryChop(min: Int, max: Int, condition: (Int) -> Boolean): Int {
        var min = min
        var max = max
        while (min < max) {
            val mid = (min + max) / 2
            if (condition(mid)) {
                max = mid
            } else {
                min = mid + 1
            }
        }
        return min
    }

    private fun canEatBananas(piles: IntArray, h: Int, k: Int): Boolean {
        var hoursRequired = 0
        for (pile in piles) {
            hoursRequired += pile / k + if (pile % k != 0) 1 else 0
        }
        return hoursRequired <= h
    }
}
