package racingcar.exception

import racingcar.view.cleanUpResource

class RacingGameException(exceptionCode: ExceptionMessage) : IllegalArgumentException(exceptionCode.message) {
    init {
        cleanUpResource()
    }
}