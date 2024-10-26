package racingcar

import racingcar.controller.RacingController
import racingcar.model.Repository
import racingcar.view.InOutView

fun main() {
    val repo = Repository()
    val inOutView = InOutView(repo)
    val racing = RacingController(repo, inOutView)

    inOutView.input()
    racing.startRacing()
}
