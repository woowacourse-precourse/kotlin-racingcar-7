package racingcar

import racingcar.presenter.RacingCarPresenter
import racingcar.view.InputView

class RacingCarGameApp(
    private val inputView: InputView,
    private val racingCarPresenter: RacingCarPresenter
) {

    fun run() {
        val carNames = inputView.readNames()
        val cars = racingCarPresenter.createRacingCars(carNames)
    }
}