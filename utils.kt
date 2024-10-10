fun gcd(a: Int, b: Int): Int {
    var (a, b) = Pair(a.coerceAtLeast(b), b.coerceAtMost(a))
    while (b != 0) {
        val rem = a % b
        a = b
        b = rem
    }
    return a
}
