package racingcar.controller

import racingcar.view.Input

class InputController {
    private val input = Input()

    fun getCarNames(): List<String> {
        return input.carNames().split(",").map {
            require(it.length in 1..5) { "자동차 이름은 1 ~ 5자로 입력해주세요. ${it}의 이름은 ${it.length}자 입니다." }
            it.trim()
        }
    }

    fun getRaceRound(): Int {
        return input.raceRound().let {
            it.toIntOrNull() ?: throw IllegalArgumentException("경주 횟수는 숫자만 입력 가능합니다. ${it}은 숫자가 아닙니다.")
        }
    }
}