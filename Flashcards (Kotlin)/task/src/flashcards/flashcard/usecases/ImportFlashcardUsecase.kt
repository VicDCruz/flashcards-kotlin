package flashcards.flashcard.usecases

import flashcards.flashcard.domain.FlashcardRepository
import flashcards.input
import flashcards.output
import java.io.File

class ImportFlashcardUsecase(private val repository: FlashcardRepository) {
    fun executeWithPath(fileName: String) {
        val file = File(fileName)

        if (!file.exists()) output("File not found.")
        else {
            var totalImported = 0
            file.forEachLine { line ->
                val strings = line.split('|')
                this.repository.create(strings[0], strings[1], strings[2].toInt())
                totalImported++
            }

            output("$totalImported cards have been loaded.")
        }
    }

    fun execute() {
        output("File name:")
        val fileName = input()
        this.executeWithPath(fileName)
    }

}