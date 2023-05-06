import kotlin.random.Random
import kotlin.random.nextInt

fun throwD6(): Int {
    val numberOnTheDice = Random.nextInt(1..6)
	return numberOnTheDice
}