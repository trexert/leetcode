class RandomizedSet() {
    val backingSet = mutableSetOf<Int>()

    fun insert(i: Int): Boolean {
        return backingSet.add(i)
    }

    fun remove(i: Int): Boolean {
        return backingSet.remove(i)
    }

    fun getRandom(): Int {
        return backingSet.random()
    }
}
