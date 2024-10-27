package racingcar.view

class OutputView {

    fun newLine() = println(NEW_LINE)

    fun printRacingResultMessage() = println(RESULT_MESSAGE)

    fun printRacingResult(carName: String, distance: String) = println("$carName$RESULT_DELIMITER$distance")

    fun printRacingWinner(winner: String) = println("$RACING_WINNER_MESSAGE$winner")

    companion object {
        private const val NEW_LINE = ""
        private const val RESULT_MESSAGE = "\n실행결과"
        private const val RESULT_DELIMITER = " : "
        private const val RACING_WINNER_MESSAGE = "최종 우승자$RESULT_DELIMITER"
    }

}
