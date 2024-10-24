package racingcar

import racingcar.controller.RacingController
import racingcar.model.Repository
import racingcar.view.InOutView

fun main() {
    val repo = Repository()
    val inOutView = InOutView()
    val racing = RacingController(repo)

    inOutView.input(repo)
    repo.separateCarName()
    racing.startRacing()
}
