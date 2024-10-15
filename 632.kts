import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayDeque

class Solution {
    fun smallestRange(nums: List<List<Int>>): IntArray {
        val smallestRange = intArrayOf(0, Int.MAX_VALUE)
        val window = ArrayDeque<Pair<Int, Int>>()
        val heap = PriorityQueue<Pair<Int, Int>>(nums.size, Comparator { (num1, i1), (num2, i2) -> num1.compareTo(num2) })
        val used = MutableList(nums.size) { 0 }
        val missing = nums.indices.toMutableSet()
        val iterators = nums.map { it.iterator() }

        for ((i, iter) in iterators.withIndex()) {
            heap.add(Pair(iter.next(), i))
        }

        while (!heap.isEmpty()) {
            val (num, addedList) = heap.remove()
            if (used[addedList] == 0) {
                missing.remove(addedList)
            }
            used[addedList]++

            window.addLast(Pair(num, addedList))
            if (iterators[addedList].hasNext()) {
                heap.add(Pair(iterators[addedList].next(), addedList))
            }

            while (missing.isEmpty()) {
                if (window.last().first - window.first().first < smallestRange[1] - smallestRange[0]) {
                    smallestRange[0] = window.first().first
                    smallestRange[1] = window.last().first
                }

                val (_, removedList) = window.removeFirst()
                used[removedList]--
                if (used[removedList] < 1) {
                    missing.add(removedList)
                }
            }
        }

        return smallestRange
    }
}
