package racingcar.ui

object OutputView {
    private const val CARS_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    private const val ROUND_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    private const val RESULT_TITLE_MESSAGE = "실행 결과"
    private const val RESULT_DELIMITER = " : "
    private const val DISTANCE_SYMBOL = "-"
    private const val WINNER_MESSAGE = "최종 우승자"
    private const val WINNER_DELIMITER = ", "

    fun printCarsNameInput() = println(CARS_NAME_INPUT_MESSAGE)

    fun printRoundCountInput() = println(ROUND_COUNT_INPUT_MESSAGE)

    fun printNewLine() = println()

    fun printResultTitle() = println(RESULT_TITLE_MESSAGE)

    fun printRoundResult(name: String, distance: Int) =
        println("$name$RESULT_DELIMITER${DISTANCE_SYMBOL.repeat(distance)}")

    fun printWinner(winners: List<String>) =
        print("$WINNER_MESSAGE$RESULT_DELIMITER${winners.joinToString(WINNER_DELIMITER)}")
}