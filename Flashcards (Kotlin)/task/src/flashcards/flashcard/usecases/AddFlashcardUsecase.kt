package flashcards.flashcard.usecases

import flashcards.flashcard.domain.FlashcardRepository
import flashcards.input
import flashcards.output

class AddFlashcardUsecase(private val repository: FlashcardRepository) {
    fun execute() {
        output("The card:")
        val term = input()
        if (this.repository.findByTerm(term) != null) {
            output("The card \"${term}\" already exists.")
        } else {
            output("The definition of the card")
            val definition = input()
            if (this.repository.existsDefinition(definition))
                output("The definition \"$definition\" already exists.")
            else {
                this.repository.create(term, definition)
                output("The pair (\"$term\":\"$definition\") has been added.")
            }
        }
    }
}