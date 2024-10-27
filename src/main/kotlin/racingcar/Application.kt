package racingcar

import racingcar.controller.CarRacing
import racingcar.view.UserInterface

fun main() {
    // TODO: 프로그램 구현
    val view = UserInterface()
    val controller = CarRacing(view)

    controller.run()
}
