package racingcar

import racingcar.controller.Controller
import racingcar.model.RacingGame
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    Controller(
        InputView(),
        OutputView(),
        RacingGame(),
    ).start()
}
