val s = Solution()
println(s.maximumSum(intArrayOf(12,2,3,4,5)))

class Solution {
    fun maximumSum(nums: IntArray): Int {
        val digitSums: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        for (num in nums) {
            var numToMod = num
            var digitSum = 0
            while (numToMod > 0) {
                digitSum += numToMod % 10
                numToMod /= 10
            }

            digitSums.getOrPut(digitSum) { mutableListOf() }.add(num)
        }

        var maxSum = -1
        digitSums.values.forEach {
            if (it.size >= 2) {
                it.sort()
                val sum = it.slice((it.size - 2)..<it.size).sum()
                if (sum > maxSum) {
                    maxSum = sum
                }
            }
        }

        return maxSum
    }
}
