package racingcar.delegate.playCount

import racingcar.constans.Constants.MAX_PLAY_COUNT
import racingcar.constans.PlayCountError.errorMessageForEmptyPlayCount
import racingcar.constans.PlayCountError.errorMessageForExceededMaxPlayCount
import racingcar.constans.PlayCountError.errorMessageForInValidPlayCount
import racingcar.constans.PlayCountError.errorMessageForInValidPlayCountByZero
import racingcar.ext.isFloat
import racingcar.ext.isNegativeNumber
import racingcar.ext.isNotNumeric

class PlayCountErrorDelegatorImpl : PlayCountErrorDelegator {
    override fun checkPlayCountIsEmpty(playCount: String) {
        if (playCount.trim().isEmpty()) {
            throw IllegalArgumentException(errorMessageForEmptyPlayCount)
        }
    }

    override fun checkForChangeableToLong(playCount: String) {
        playCount.toLongOrNull() ?: throw IllegalArgumentException(
            errorMessageForExceededMaxPlayCount
        )
    }

    override fun checkForExceededMaxInt(playCount: Long) {
        if (playCount > Int.MAX_VALUE) {
            throw IllegalArgumentException(errorMessageForExceededMaxPlayCount)
        }
    }

    override fun checkInvalidPlayCountFormat(playCount: String) {
        if (playCount.isNotNumeric()) {
            throw IllegalArgumentException(errorMessageForInValidPlayCount)
        }
    }

    override fun checkInvalidPlayCountRange(playCount: String) {
        if (playCount.isNegativeNumber() || playCount.isFloat()) {
            throw IllegalArgumentException(errorMessageForInValidPlayCount)
        }
    }

    override fun checkInvalidPlayCountByZero(playCount: Int) {
        if (playCount == 0) {
            throw IllegalArgumentException(errorMessageForInValidPlayCountByZero)
        }
    }

    override fun checkExceededMaxPlayCount(playCount: Int) {
        if (playCount > MAX_PLAY_COUNT) {
            throw IllegalArgumentException(errorMessageForExceededMaxPlayCount)
        }
    }
}