package flashcards

import flashcards.log.LoggerRepositoryInMemory

val loggerRepository = LoggerRepositoryInMemory()

fun input(): String {
    val input = readln()
    loggerRepository.create(input)
    return input
}

fun output(text: String) {
    loggerRepository.create(text)
    println(text)
}
