package flashcards.flashcard.usecases

import flashcards.flashcard.domain.FlashcardRepository
import flashcards.input
import flashcards.output
import java.io.File
import java.lang.StringBuilder

class ExportFlashcardUsecase(private val repository: FlashcardRepository) {
    fun execute() {
        output("File name:")
        val fileName = input()
        this.executeWithPath(fileName)
    }

    fun executeWithPath(fileName: String) {
        val stringBuilder = StringBuilder()

        var totalExported = 0
        this.repository.find().forEach {
            totalExported++
            stringBuilder.appendLine("${it.term}|${it.definition}|${it.getMistakes()}")
        }

        File(fileName).writeText(stringBuilder.toString())
        output("$totalExported cards have been saved.")
    }
}