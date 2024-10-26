package racingcar.view

import racingcar.util.isValidCarName
import racingcar.util.parseCarNames

class ViewModel {
    var carNames: List<String>? = null
        private set
    var round: Int? = null
        private set

    fun updateCarNames(input: String) {
        val newCarNames = parseCarNames(input)
        if (newCarNames.any { carName -> !carName.isValidCarName }) throw IllegalArgumentException()
        carNames = newCarNames
    }

    fun updateRound(input: Int) {
        if (input <= 0) throw IllegalArgumentException()
        this.round = input
    }
}