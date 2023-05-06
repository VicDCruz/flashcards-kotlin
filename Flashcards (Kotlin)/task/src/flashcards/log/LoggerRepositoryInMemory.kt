package flashcards.log

class LoggerRepositoryInMemory : LoggerRepository {
    val logs = mutableListOf<String>()

    override fun find(): List<String> {
        return this.logs.toList()
    }

    override fun create(action: String) {
        this.logs.add(action)
    }
}