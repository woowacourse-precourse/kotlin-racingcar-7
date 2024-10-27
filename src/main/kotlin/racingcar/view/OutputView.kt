package racingcar.view

class OutputView {
    fun printInputNameMessage() {
        println(GET_NAME_OF_CAR_MESSAGE)
    }

    fun printInputCountMessage() {
        println(GET_COUNT_MESSAGE)
    }

    fun printResultMessage() {
        println()
        println(RESULT_MESSAGE)
    }

    fun printStatusOfMove(infoOfCar: MutableMap<String, Int>) {
        for ((name, move) in infoOfCar) {
            printStatusOfName(name)
            for (i in 1..move) {
                print(MOVE_SYMBOL)
            }
            println()
        }
        println()
    }

    fun printWinnerMessage(winner: Set<String>) {
        print(WINNER_MESSAGE)
        val winnerName = winner.joinToString(WINNER_DELIMITER)
        print(winnerName)
    }

    private fun printStatusOfName(name: String) {
        print("$name$NAME_DELIMITER")
    }

    companion object {
        private const val GET_NAME_OF_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val GET_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
        private const val RESULT_MESSAGE = "실행 결과"
        private const val NAME_DELIMITER = " : "
        private const val MOVE_SYMBOL = "-"
        private const val WINNER_MESSAGE = "최종 우승자 : "
        private const val WINNER_DELIMITER = ", "
    }
}