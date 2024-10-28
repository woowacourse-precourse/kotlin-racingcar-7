package racingcar.view

object OutputView {
    fun printExecutionResult() {
        println(OUTPUT_EXECUTION_RESULT_MESSAGE)
    }

    fun printCarPosition(name: String, position: Int) {
        println(name + CAR_POSITION_DELIMITER + CAR_POSITION_SYMBOL.repeat(position))
    }

    private const val OUTPUT_EXECUTION_RESULT_MESSAGE = "실행 결과"

    private const val CAR_POSITION_DELIMITER = " : "
    private const val CAR_POSITION_SYMBOL = "-"
}