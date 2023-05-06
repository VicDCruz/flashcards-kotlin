package flashcards.flashcard.domain

interface FlashcardRepository {
    fun find(): List<Flashcard>
    fun findByTerm(term: String): Flashcard?
    fun findHardestCards(): List<Flashcard>
    fun create(term: String, definition: String): Boolean
    fun create(term: String, definition: String, mistakes: Int): Boolean
    fun existsDefinition(definition: String): Boolean
    fun remove(term: String): Boolean
    fun findByDefinition(definition: String): Flashcard
}