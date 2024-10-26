package racingcar.view

import racingcar.domain.RacingCars

object OutputView {
    private const val PROCESS_MESSAGE = "실행 결과"
    private const val WINNER_MESSAGE = "최종 우승자 : "
    private const val STEP_MESSAGE = " : "
    private const val POSITION_INDICATOR = "-"
    private const val WINNER_SEPARATOR = ","

    fun printProcess() = println(PROCESS_MESSAGE)

    fun printMidResult(racingCars: RacingCars) {
        racingCars.racingCars.forEach {
            println("${it.name}$STEP_MESSAGE${POSITION_INDICATOR.repeat(it.position)}")
        }
        println()
    }

    fun printResult(result: List<String>) {
        println(WINNER_MESSAGE + result.joinToString(WINNER_SEPARATOR))
    }
}
