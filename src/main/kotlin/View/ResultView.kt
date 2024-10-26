package View

object ResultView {
    fun printRaceProgress(progress: List<String>) {
        progress.forEach { println(it) }
        println()
    }

    fun printWinners(winners: List<String>) {
        println("최종 우승자 : ${winners.joinToString(", ")}")
    }
}