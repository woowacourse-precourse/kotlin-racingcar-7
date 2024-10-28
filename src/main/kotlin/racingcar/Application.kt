package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.domain.Car
import racingcar.domain.tryMove
import racingcar.ui.Ui

fun main() {
    val ui = Ui()

    val carNames = ui.requestCarNames()
    val cars = carNames.map { carName -> Car(carName, Randoms::pickNumberInRange) }

    val tryNumber = ui.requestTryNumber()

    cars.tryMove()
    ui.displayTryResult(cars)
}
