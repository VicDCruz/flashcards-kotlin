package flashcards

import flashcards.flashcard.infrastructure.FlashcardRepositoryInMemory
import flashcards.flashcard.usecases.*
import flashcards.log.usecases.ExportLogUsecase

fun main(args: Array<String>) {
    val logRepository = loggerRepository
    val repository = FlashcardRepositoryInMemory()
    import(args.toList(), repository)
    var isRunning = true
    while (isRunning) {
        output("Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):")
        when (input().lowercase()) {
            "add" -> AddFlashcardUsecase(repository).execute()
            "remove" -> RemoveFlashcardUsecase(repository).execute()
            "import" -> ImportFlashcardUsecase(repository).execute()
            "export" -> ExportFlashcardUsecase(repository).execute()
            "ask" -> AskFlashcardUsecase(repository).execute()
            "log" -> ExportLogUsecase(logRepository).execute()
            "hardest card" -> GetHardestFlashcardUsecase(repository).execute()
            "reset stats" -> ResetMistakesFlashcardUsecase(repository).execute()
            "exit" -> isRunning = false
        }
    }
    export(args.toList(), repository)
    output("Bye bye!")
}

fun import(args: List<String>, repository: FlashcardRepositoryInMemory) {
    val indexOf = args.indexOf("-import")
    if (indexOf > -1) ImportFlashcardUsecase(repository).executeWithPath(args[indexOf + 1])
}

fun export(args: List<String>, repository: FlashcardRepositoryInMemory) {
    val indexOf = args.indexOf("-export")
    if (indexOf > -1) ExportFlashcardUsecase(repository).executeWithPath(args[indexOf + 1])
}
