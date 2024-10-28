package racingcar.utils

import racingcar.view.OutputView

object ValidateCarNames {

    private val outputView = OutputView

    fun checkIfEmpty(carNames: List<String>) {
        if (carNames.any { it.isEmpty() }) {
            throw IllegalArgumentException("이름이 전부 입력되지 않았습니다.")
        }
    }

    fun checkLength(carNames: List<String>) {
        if (carNames.any { it.length > 5 }) {
            throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
        }
    }

    fun checkDuplicates(carNames: List<String>): Collection<String> {
        return if (carNames.size != carNames.toSet().size) {
            outputView.displayDup()
            carNames.toSet()
        } else carNames
    }
}