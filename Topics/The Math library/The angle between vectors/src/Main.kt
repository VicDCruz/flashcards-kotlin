import kotlin.math.*

fun main() {
    val u = readln().split(" ").map { it.toDouble() }
    val v = readln().split(" ").map { it.toDouble() }
    val dotProduct = u[0] * v[0] + u[1] * v[1]
    val magnitudeU = sqrt(u[0].pow(2) + u[1].pow(2))
    val magnitudeV = sqrt(v[0].pow(2) + v[1].pow(2))
    println(acos(dotProduct / (magnitudeU * magnitudeV)) * 180 / PI)
}