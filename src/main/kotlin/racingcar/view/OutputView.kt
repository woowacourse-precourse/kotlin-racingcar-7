package racingcar.view

object OutputView {
    private const val START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    private const val ATTEMPT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    private const val RESULT_MESSAGE = "실행 결과"
    private const val WINNER_MESSAGE = "최종 우승자 : "
    private const val COLON = " : "
    private const val POSITION_SIGN = "-"
    private const val SEPARATOR = ", "

    fun printStartMessage() {
        println(START_MESSAGE)
    }

    fun printAttemptMessage() {
        println(ATTEMPT_MESSAGE)
    }

    fun printResultMessage() {
        println()
        println(RESULT_MESSAGE)
    }

    fun printPosition(car: String, position: Int) {
        println("$car$COLON" + POSITION_SIGN.repeat(position))
    }

    fun printWinners(winnerList: List<String>) {
        val winners = winnerList.joinToString(SEPARATOR)
        println("${WINNER_MESSAGE}${winners}")
    }
}
