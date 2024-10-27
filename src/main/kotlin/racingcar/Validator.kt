package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.Strings.ERROR_NAME_LENGTH
import racingcar.Strings.ERROR_DUPLICATE_NAME
import racingcar.Strings.ERROR_INVALID_TRY_COUNT

class Validator {
    fun validateNameLength(carNames: List<String>) {
        if (carNames.any { it.isEmpty() || it.length > MAX_NAME_LENGTH }) {
            throw IllegalArgumentException(ERROR_NAME_LENGTH)
        }
    }

    fun validateNameDuplication(carNames: List<String>) {
        if (carNames.size != carNames.distinct().size) {
            throw IllegalArgumentException(ERROR_DUPLICATE_NAME)
        }
    }

    fun validateTryCount(tryCount: Int) {
        if (tryCount < MIN_TRY_COUNT) {
            throw IllegalArgumentException(ERROR_INVALID_TRY_COUNT)
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