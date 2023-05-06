package flashcards.flashcard.usecases

import flashcards.flashcard.domain.FlashcardRepository
import flashcards.input
import flashcards.output

class RemoveFlashcardUsecase(private val repository: FlashcardRepository) {
    fun execute() {
        output("Which card?")
        val term = input()
        if (this.repository.findByTerm(term) != null) {
            this.repository.remove(term)
            output("The card has been removed.")
        } else output("Can't remove \"$term\": there is no such card.")
    }
}