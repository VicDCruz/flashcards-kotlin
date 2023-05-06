package flashcards.flashcard.usecases

import flashcards.flashcard.domain.FlashcardRepository
import flashcards.output

class GetHardestFlashcardUsecase(private val repository: FlashcardRepository) {
    fun execute() {
        val hardestCards = this.repository.findHardestCards()
        if (hardestCards.isEmpty())
            output("There are no cards with errors.")
        else {
            output("The hardest ${if (hardestCards.size > 1) "cards are" else "card is"} ${hardestCards.joinToString(", ") { "\"${it.term}\"" }}. You have ${hardestCards[0].getMistakes()} errors answering ${if (hardestCards.size > 1) "them" else "it"}")
        }
    }
}