val s = Solution()
println(s.getHappyString(1, 3))
println(s.getHappyString(1, 4))
println(s.getHappyString(3, 9))

class Solution {
    fun getHappyString(n: Int, k: Int): String {
        var foundStrings = 0
        val stringStack: MutableList<Char> = mutableListOf('a')
        while (true) {
            if (stringStack.size < n && !(stringStack.size > 1 && stringStack[stringStack.size - 1] == stringStack[stringStack.size - 2])) {
                stringStack.add('a')
            } else {
                if (stringStack.size == n && isHappy(stringStack)) {
                    foundStrings++
                    if (foundStrings == k) {
                        break
                    }
                }

                while (stringStack.lastOrNull() == 'c') {
                    stringStack.removeLast()
                }

                // Every character has been tried in every slot
                if (stringStack.isEmpty()) {
                    break
                }

                stringStack[stringStack.size - 1]++
            }
        }

        return if (foundStrings < k) {
            ""
        } else {
            stringStack.joinToString("")
        }
    }

    fun isHappy(stringStack: List<Char>): Boolean {
        var prev = stringStack.firstOrNull()
        for (c in stringStack.slice(1 until stringStack.size)) {
            if (prev == c) {
                return false
            }
            prev = c
        }
        return true
    }
}
