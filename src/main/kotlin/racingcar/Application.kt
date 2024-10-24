package racingcar

import racingcar.model.Repository
import racingcar.view.InOutView

fun main() {
    val repo = Repository()
    val inOutView = InOutView()

    inOutView.input(repo)
}
