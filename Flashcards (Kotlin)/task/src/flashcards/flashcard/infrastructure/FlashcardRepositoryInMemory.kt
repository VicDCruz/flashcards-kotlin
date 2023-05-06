package flashcards.flashcard.infrastructure

import flashcards.flashcard.domain.Flashcard
import flashcards.flashcard.domain.FlashcardRepository

class FlashcardRepositoryInMemory : FlashcardRepository {
    private val flashcards = mutableListOf<Flashcard>()

    override fun find(): List<Flashcard> = this.flashcards

    override fun findByTerm(term: String): Flashcard? {
        return this.flashcards.find { it.term == term }
    }

    override fun findHardestCards(): List<Flashcard> {
        val maxFlashcard = this.flashcards.maxByOrNull { it.getMistakes() }
        val highestMistakes = maxFlashcard?.getMistakes() ?: 0
        if (maxFlashcard === null || highestMistakes == 0) return emptyList()
        return this.flashcards.filter { it.getMistakes() == highestMistakes }
    }

    override fun findByDefinition(definition: String): Flashcard {
        return this.flashcards.find { it.definition == definition }!!
    }

    override fun existsDefinition(definition: String): Boolean {
        return this.flashcards.any { it.definition == definition }
    }

    override fun create(term: String, definition: String): Boolean {
        return this.flashcards.add(Flashcard(term, definition))
    }

    override fun create(term: String, definition: String, mistakes: Int): Boolean {
        val flashcard = Flashcard(term, definition)
        flashcard.setMistakes(mistakes)
        return this.flashcards.add(flashcard)
    }

    override fun remove(term: String): Boolean {
        return this.flashcards.removeIf { it.term == term }
    }
}