package racingcar.controller

import racingcar.view.ErrorView
import racingcar.view.InputView

class RacingCarController {
    private val view = InputView
    private val errorview = ErrorView

    fun start() {
        try {
            val carNames = getCarNames()
        } catch (e: IllegalArgumentException) {
            errorview.errorMessage(e.message ?: "오류가 발생했습니다.")
        }
    }

    private fun getCarNames(): List<String> {
        val input = view.askForCarNames()
        val carNames = input.split(",").map { it.trim() }
        require(carNames.all { it.length <= 5 }) { "자동차 이름은 5자 이하만 가능합니다." }
        return carNames
    }
}