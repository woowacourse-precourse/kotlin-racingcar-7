package racingcar

import camp.nextstep.edu.missionutils.Console

class Validation {

    fun validateCarNames(carNames: List<String>): List<String> {
        return carNames.apply {
            forEach { validateCarName(it) }
        }
    }
    private fun validateCarName(name: String) {
        require(name.isNotBlank()) { "자동차 이름을 입력해주세요." }
        require(name.length <= 5) { "이름은 5자 이하로 입력해주세요." }
    }

    fun getAttemptTimes(attemptTimes: String): Int =
        attemptTimes.toIntOrNull() ?: throw IllegalArgumentException("시도 횟수를 입력해주세요.")
}
