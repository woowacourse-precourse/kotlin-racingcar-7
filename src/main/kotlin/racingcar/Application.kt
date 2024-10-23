package racingcar

import racingcar.presenter.RacingCarPresenter
import racingcar.view.InputViewImpl

fun main() {
    val inputView = InputViewImpl()
    val racingCarPresenter = RacingCarPresenter()

    RacingCarGameApp(inputView, racingCarPresenter).run()
}
