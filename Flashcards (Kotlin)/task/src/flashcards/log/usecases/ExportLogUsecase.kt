package flashcards.log.usecases

import flashcards.input
import flashcards.log.LoggerRepository
import flashcards.output
import java.io.File
import java.lang.StringBuilder

class ExportLogUsecase(private val repository: LoggerRepository) {
    fun execute() {
        output("File name:")
        val fileName = input()
        val logs = this.repository.find()
        val stringBuilder = StringBuilder()

        logs.forEach { stringBuilder.appendLine(it) }
        File(fileName).writeText(stringBuilder.toString())
        output("The log has been saved.")
    }
}