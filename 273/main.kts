main()

fun main() {
    val s = Solution()
    println(s.numberToWords(2123))
    println(s.numberToWords(0))
    println(s.numberToWords(53))
    println(s.numberToWords(840922123))
    println(s.numberToWords(1000823))
}

class Solution {
    fun numberToWords(num: Int): String {
        var num = num
        if (num == 0) return "Zero"

        val blocks = mutableListOf<String>()

        while (num > 0) {
            blocks.add(maxThreeDigitToWords(num % 1000))
            num /= 1000
        }

        val result = mutableListOf<String>()
        while (blocks.isNotEmpty()) {
            val threeDigitBlock = blocks.removeLast()
            if (threeDigitBlock.isNotEmpty()) result.add("${threeDigitBlock}${thousandsToWords(blocks.size)}")
        }

        return result.joinToString(" ")
    }

    fun thousandsToWords(num: Int): String = when (num) {
        0 -> ""
        1 -> " Thousand"
        2 -> " Million"
        3 -> " Billion"
        else -> throw Exception("Number longer than expected, received thousands count of $num")
    }

    fun maxThreeDigitToWords(num: Int): String = if (num < 100) {
        maxTwoDigitToWords(num)
    } else {
        val nonHundreds = maxTwoDigitToWords(num % 100)
        if (nonHundreds.isEmpty()) {
            "${oneDigitToWord(num / 100)} Hundred"
        } else {
            "${oneDigitToWord(num / 100)} Hundred ${maxTwoDigitToWords(num % 100)}"
        }
    }

    fun maxTwoDigitToWords(num: Int): String = when {
        num < 10 -> oneDigitToWord(num)
        num < 20 -> teenWords(num)
        num < 100 -> {
            if (num % 10 == 0) {
                tens(num/10)
            } else {
                "${tens(num/10)} ${oneDigitToWord(num % 10)}"
            }
        }
        else -> throw Exception("Expected 2 digit number, received $num")
    }

    fun tens(num: Int): String = when (num) {
        2 -> "Twenty"
        3 -> "Thirty"
        4 -> "Forty"
        5 -> "Fifty"
        6 -> "Sixty"
        7 -> "Seventy"
        8 -> "Eighty"
        9 -> "Ninety"
        else -> "Expected a non-teen tens number, recieved $num"
    }

    fun teenWords(num: Int): String = when (num) {
        10 -> "Ten"
        11 -> "Eleven"
        12 -> "Twelve"
        13 -> "Thirteen"
        14 -> "Fourteen"
        15 -> "Fifteen"
        16 -> "Sixteen"
        17 -> "Seventeen"
        18 -> "Eighteen"
        19 -> "Nineteen"
        else -> throw Exception("Expected teen, received $num")
    }

    fun oneDigitToWord(num: Int): String = when (num) {
        0 -> ""
        1 -> "One"
        2 -> "Two"
        3 -> "Three"
        4 -> "Four"
        5 -> "Five"
        6 -> "Six"
        7 -> "Seven"
        8 -> "Eight"
        9 -> "Nine"
        else -> throw Exception("Expected one digit, received $num")
    }
}