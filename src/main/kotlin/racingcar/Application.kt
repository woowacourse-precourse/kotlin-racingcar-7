package racingcar

import racingcar.domain.Car
import racingcar.ui.Ui

fun main() {
    val ui = Ui()

    val carNames = ui.requestCarNames()
    val cars = carNames.map(::Car)
}
