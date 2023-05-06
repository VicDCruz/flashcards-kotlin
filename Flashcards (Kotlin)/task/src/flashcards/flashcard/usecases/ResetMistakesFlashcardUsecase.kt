package flashcards.flashcard.usecases

import flashcards.flashcard.domain.FlashcardRepository
import flashcards.output

class ResetMistakesFlashcardUsecase(private val repository: FlashcardRepository) {
    fun execute() {
        repository.find().forEach { it.resetMistakes() }
        output("Card statistics have been reset.")
    }
}