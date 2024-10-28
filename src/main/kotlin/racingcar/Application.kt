package racingcar

import racingcar.presenter.RacingCarPresenter
import racingcar.util.ConstantsUtil.MESSAGE_INPUT_CAR_NAME
import racingcar.util.ConstantsUtil.MESSAGE_INPUT_ROUND
import racingcar.view.RacingCarView
import racingcar.view.RacingCarViewImpl

fun main() {
    val view: RacingCarView = RacingCarViewImpl()
    val presenter = RacingCarPresenter(view)

    val carNames = view.getUserInput(MESSAGE_INPUT_CAR_NAME).split(",")
    val round = view.getUserInput(MESSAGE_INPUT_ROUND)

    presenter.startRacingCar(carNames, round)
}
