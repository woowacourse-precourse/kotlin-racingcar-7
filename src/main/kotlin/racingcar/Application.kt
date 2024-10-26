package racingcar

import Controller.RacingGameController
import Model.RandomMoveStrategy

fun main() {
    RacingGameController(RandomMoveStrategy()).playGame()
}

