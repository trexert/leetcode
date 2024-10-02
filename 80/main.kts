class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var write = 1
        var lastElement: Int = nums[0]
        var lastElementSeenTwice = false
        for (read in 1..<nums.size) {
            val elt = nums[read]
            if (elt != lastElement || !lastElementSeenTwice) {
                nums[write] = elt
                write++
            }
            lastElementSeenTwice = elt == lastElement
            lastElement = elt
        }
        return write
    }
}
