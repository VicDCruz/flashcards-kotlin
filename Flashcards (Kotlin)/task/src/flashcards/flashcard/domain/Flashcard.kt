package flashcards.flashcard.domain

class Flashcard(val term: String, val definition: String) {
    private var mistakes = 0

    fun incrementMistake() {
        this.mistakes++
    }

    fun getMistakes(): Int {
        return this.mistakes
    }

    fun resetMistakes() {
        this.mistakes = 0
    }

    fun setMistakes(mistakes: Int) {
        this.mistakes = mistakes
    }
}