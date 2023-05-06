import kotlin.math.*

fun main() {
    val a = readln().toDouble()
    val b = readln().toDouble()
    val c = readln().toDouble()

    val p = (a + b + c) / 2

    println(sqrt(p * (p - a) * (p - b) * (p - c)))
}