package racingcar.view

object OutputView {
    fun printExecutionResult() {
        println(OUTPUT_EXECUTION_RESULT_MESSAGE)
    }

    fun printCarPosition(name: String, position: Int) {
        println(name + RESULT_DELIMITER + CAR_POSITION_SYMBOL.repeat(position))
    }

    fun printWinners(winners: List<String>) {
        println(OUTPUT_WINNER_MESSAGE + RESULT_DELIMITER + winners.joinToString(WINNER_DELIMITER))
    }

    private const val OUTPUT_EXECUTION_RESULT_MESSAGE = "실행 결과"
    private const val OUTPUT_WINNER_MESSAGE = "최종 우승자"

    private const val CAR_POSITION_SYMBOL = "-"
    private const val RESULT_DELIMITER = " : "
    private const val WINNER_DELIMITER = ", "
}