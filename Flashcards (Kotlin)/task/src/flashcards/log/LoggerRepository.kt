package flashcards.log

interface LoggerRepository {
    fun find(): List<String>
    fun create(action: String)
}