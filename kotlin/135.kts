val s = Solution()
println(s.candy(intArrayOf(1,0,2)))
println(s.candy(intArrayOf(1,2,2,1,2,3,4,4,1,2,3,2)))

class Solution {
    fun candy(ratings: IntArray): Int {
        val candies = mutableListOf<MutableList<Int>?>()
        var previous: Int? = null
        var increasing = false
        for (rating in ratings) {
            when {
                previous == null || rating == previous -> {
                    increasing = false
                    candies.add(mutableListOf(1))
                }
                rating > previous -> {
                    increasing = true
                    candies.last()!!.add(candies.last()!!.last() + 1)
                }
                rating < previous && !increasing -> candies.last()!!.add(candies.last()!!.last() - 1)
                rating < previous && increasing -> {
                    // Just had a strict maximum. Use null to represent this, and make it one more than its greater neighbour when counting
                    candies.last()!!.removeLast()
                    candies.add(null)

                    increasing = false
                    candies.add(mutableListOf(1))
                }
            }

            previous = rating
        }

        println(candies)

        var candiesCount = 0
        var childsCandies = 0
        var handlePeak = false
        for (candiesBlock in candies) {
            if (candiesBlock == null) {
                handlePeak = true
            } else {
                val minCandies = candiesBlock.min()
                for (i in candiesBlock) {
                    if (handlePeak) {
                        childsCandies = Math.max(childsCandies, i - minCandies + 1) + 1
                        println(childsCandies)
                        candiesCount += childsCandies
                        handlePeak = false
                    }
                    childsCandies = i - minCandies + 1
                    println(childsCandies)
                    candiesCount += childsCandies
                }
            }
        }

        return candiesCount
    }
}
