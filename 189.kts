val s = Solution()
val a = intArrayOf(1, 2, 3, 4)
s.rotate(a, 5)
println(a.joinToString())

class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        if (nums.size < 2 || k == 0) return
        val offsetCount = gcd(nums.size, k)
        val orbitSize = nums.size / offsetCount
        for (off in 0..<offsetCount) {
            var elt = nums[(off - k).mod(nums.size)]
            for (i in off..<(orbitSize * k) + off step k) {
                nums[i % nums.size] = elt.also { elt = nums[i % nums.size]}
            }
        }
    }
}

fun gcd(a: Int, b: Int): Int {
    var (a, b) = Pair(Math.max(a, b), Math.min(a, b))
    while (b != 0) {
        a = b.also { b = a % b }
    }
    return a
}
