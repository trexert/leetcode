fun gcd(a: Int, b: Int): Int {
    val (a, b) = (Math.max(a, b), Math.min(a, b))
    while (b != 0) {
        val rem = a % b
        a = b
        b = rem
    }
    return a
}
