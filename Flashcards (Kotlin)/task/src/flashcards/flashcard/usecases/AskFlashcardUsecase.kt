package flashcards.flashcard.usecases

import flashcards.flashcard.domain.FlashcardRepository
import flashcards.input
import flashcards.output

class AskFlashcardUsecase(private val repository: FlashcardRepository) {
    fun execute() {
        output("How many times to ask?")
        val times = input().toInt()

        val flashcards = this.repository.find()

        repeat(times) {
            val flashcard = flashcards[times % flashcards.size]
            output("Print the definition of \"${flashcard.term}\":")
            this.verifyResponse(flashcard.definition, input())
        }
    }

    private fun verifyResponse(definition: String, response: String) {
        if (definition == response) output("Correct!")
        else {
            this.repository.findByDefinition(definition).incrementMistake()
            if (this.repository.existsDefinition(response)) {
                val flashcard = this.repository.findByDefinition(response)
                output("Wrong. The right answer is \"$definition\", but your definition is correct for \"${flashcard.term}\".")
            } else output("Wrong. The right answer is \"$definition\".")
        }
    }
}