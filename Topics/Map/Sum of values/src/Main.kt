fun summator(map: Map<Int, Int>): Int {
    var accumulator = 0
    for (entry in map) accumulator += if (entry.key % 2 == 0) entry.value else 0
    return accumulator
}