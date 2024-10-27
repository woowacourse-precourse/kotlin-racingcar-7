package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Validator {
    fun validateCarNames(carNames: List<String>) {
        if (carNames.any { it.isEmpty() || it.length > MAX_NAME_LENGTH }) {
            throw IllegalArgumentException(Messages.ERROR_NAME_LENGTH)
        }
        if (carNames.size != carNames.distinct().size) {
            throw IllegalArgumentException(Messages.ERROR_DUPLICATE_NAME)
        }
    }

    fun validateTryCount(tryCount: Int) {
        if (tryCount < MIN_TRY_COUNT) {
            throw IllegalArgumentException(Messages.ERROR_INVALID_TRY_COUNT)
        }
    }

    fun isAllowedForMove(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= MIN_FORWARD_VALUE
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
        private const val MIN_TRY_COUNT = 1
        private const val MIN_FORWARD_VALUE = 4
    }
}