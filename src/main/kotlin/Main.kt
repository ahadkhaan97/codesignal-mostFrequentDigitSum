fun main() {
    print(solution(17))
}

fun solution(n: Int): Int {
    if(n.toString().length == 1)
        return n
    val series = mutableListOf<Int>()
    val map = HashMap<Int, Int>()
    series.add(n)
    map[n.toString().map { it.digitToInt() }.sum()] = 1
    while (true) {
        series.add(series[series.size - 1] - series[series.size - 1].toString().map { it.digitToInt() }.sum())
        val key = series[series.size - 1].toString().map { it.digitToInt() }.sum()
        map[key] = (map[key] ?: 0) + 1
        if (key == 0)
            break
    }

    var maxKey = 0
    var maxValue: Int = Int.MIN_VALUE

    for ((key, value) in map) {
        if (value >= maxValue) {
            maxKey = key
            maxValue = value
        }
    }
    return maxKey
}
