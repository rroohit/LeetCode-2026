package e_may

fun main() {

    val testCases = listOf(
        Pair(10, intArrayOf(3, 9, 19, 5, 21)),
        Pair(5, intArrayOf(4, 9, 23, 4))
    )

    testCases.forEach { (mass, asteroids) ->
        println("Result --> ${asteroidsDestroyed(mass, asteroids)}")
    }

}

// TC - O(n logn) :: SC - O(n)
fun asteroidsDestroyed(mass: Int, asteroids: IntArray): Boolean {
    asteroids.sort()
    var newMass = mass.toLong()
    for (ast in asteroids) {
        if (ast > newMass) return false
        newMass += ast
    }
    return true
}