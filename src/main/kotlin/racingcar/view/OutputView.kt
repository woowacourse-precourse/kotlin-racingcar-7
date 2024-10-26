package racingcar.view

class OutputView {
    fun printOutputRaceResult() = println("\n$OUTPUT_RACE_RESULT_MESSAGE")
    fun printOutputWinner(winner: List<String>) = println("$OUTPUT_WINNER_MESSAGE${winner.joinToString(", ")}")

    companion object {
        const val OUTPUT_RACE_RESULT_MESSAGE = "실행 결과"
        const val OUTPUT_WINNER_MESSAGE = "최종 우승자 : "
    }
}