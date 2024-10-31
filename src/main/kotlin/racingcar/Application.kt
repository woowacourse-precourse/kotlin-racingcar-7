package racingcar

import racingcar.presenter.RacingCarPresenter
import racingcar.view.InputViewImpl
import racingcar.view.OutputViewImpl

fun main() {
    val inputView = InputViewImpl()
    val outputView = OutputViewImpl()
    val racingCarPresenter = RacingCarPresenter(outputView)

    RacingCarGameApp(inputView, racingCarPresenter).run()
}
