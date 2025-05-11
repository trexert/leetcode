import kotlin.math.min

val s = Solution()
println(s.minimumTotal(listOf(listOf(2), listOf(3,4), listOf(6,5,7), listOf(4,1,8,3))))
println(s.minimumTotal(listOf(listOf(-10))))

class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        var lastRow = listOf(triangle[0][0])
        for (row in triangle.drop(1)) {
            val newRow = mutableListOf<Int>()
            for ((i, value) in row.withIndex()) {
                when (i) {
                    0 -> newRow.add(lastRow[0] + value)
                    row.size - 1 -> newRow.add(lastRow.last() + value)
                    else -> newRow.add(min(lastRow[i - 1], lastRow[i]) + value)
                }
            }
            lastRow = newRow
        }
        return lastRow.min()
    }
}
