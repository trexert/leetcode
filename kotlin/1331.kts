val s = Solution()
val arr = intArrayOf(40,10,20,30)
println(s.arrayRankTransform(arr).joinToString())

class Solution {
    fun arrayRankTransform(arr: IntArray): IntArray {
        // val sortedArray = arr.sorted()

        // val ranks = mutableMapOf<Int, Int>()
        // var lastRank = 0
        // for (i in sortedArray) {
        //     ranks.getOrPut(i) { ++lastRank }
        // }

        // val result = mutableListOf<Int>()
        // for (i in arr) {
        //     result.add(ranks[i]!!)
        // }

        val elements = arr.sorted().distinct()

        val result = mutableListOf<Int>()
        for (i in arr) {
            result.add(elements.binarySearch(i) + 1)
        }

        return result.toIntArray()
    }
}