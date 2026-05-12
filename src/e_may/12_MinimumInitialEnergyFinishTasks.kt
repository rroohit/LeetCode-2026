package e_may

fun main() {



}

fun minimumEffort(tasks: Array<IntArray>): Int {
    tasks.sortWith { a, b ->
        (a[1] - a[0]) - (b[1] - b[0])
    }
    var ans = 0
    for (task in tasks) {
        ans = maxOf(ans + task[0], task[1])
    }
    return ans
}