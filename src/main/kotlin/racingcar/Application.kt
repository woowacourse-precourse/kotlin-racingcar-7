package racingcar

import racingcar.controller.RacingCarController
import racingcar.domain.RandomNumberImpl
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {

    RacingCarController(
        inputView = InputView(),
        outputView = OutputView(),
        randomNumberImpl = RandomNumberImpl()
    ).run()

}
