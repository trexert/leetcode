val s = Solution()
println(s.longestDiverseString(1, 1, 7))

class Solution {
    fun longestDiverseString(a: Int, b: Int, c: Int): String {
        val queue = mutableListOf<Pair<Int, Char>>()
        if (a > 0) queue.add(Pair(a, 'a'))
        if (b > 0) queue.add(Pair(b, 'b'))
        if (c > 0) queue.add(Pair(c, 'c'))
        queue.sortWith { l, r -> l.first.compareTo(r.first) }

        val happyString = mutableListOf<Char>()
        while (queue.isNotEmpty()) {
            var index = queue.size - 1
            if (happyString.takeLast(2) == listOf(queue[index].second, queue[index].second)) {
                index--
            }
            if (index < 0) break

            happyString.add(queue[index].second)

            queue[index] = Pair(queue[index].first - 1, queue[index].second)
            if (queue[index].first < 1) {
                queue.removeAt(index)
            }

            queue.sortWith { l, r -> l.first.compareTo(r.first) }
        }
        return happyString.joinToString(separator = "")
    }
}
