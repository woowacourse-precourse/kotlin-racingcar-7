package racingcar

import racingcar.controller.RacingController
import racingcar.domain.numbergenerator.RandomNumberGenerator

fun main() {
    val racingGame = RacingController(RandomNumberGenerator())
    racingGame.play()
}
