val s = Solution()
println(s.minSwaps("[]"))

class Solution {
    fun minSwaps(s: String): Int {
        var closingToSwap = 0
        var opensToClose = 0

        for (c in s) {
            when {
                c == '[' -> opensToClose++
                c == ']' && opensToClose > 0 -> opensToClose--
                c == ']' && opensToClose == 0 -> {
                    closingToSwap++
                    opensToClose++
                }
                else -> throw Exception("Unexpected state")
            }
        }

        return closingToSwap
    }
}
