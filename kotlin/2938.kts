val s = Solution()
println(s.minimumSteps("101"))
println(s.minimumSteps("100"))
println(s.minimumSteps("00111"))

class Solution {
    fun minimumSteps(s: String): Long {
        var blackBallsToMove = 0L
        var swaps = 0L
        for (c in s) {
            when (c) {
                '0' -> swaps += blackBallsToMove
                '1' -> blackBallsToMove++
                else -> throw Exception("Unexpected character in input")
            }
        }
        return swaps
    }
}
