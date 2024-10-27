package racingcar.util

import racingcar.model.RacingGame

object RacingGameValidator {

    private const val INSUFFICIENT_CARS_ERROR_MESSAGE = "자동차 경주는 2대 이상인 경우만 가능합니다."

    fun validateRacingGame(racingGame: RacingGame) {
        if (racingGame.getCars().size == 1) throw IllegalArgumentException(INSUFFICIENT_CARS_ERROR_MESSAGE)
    }
}