package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms
import racingcar.view.OutputView

class RacingCar(
    val name: String,
    var position: Int = 0
) {
    fun play() {
        val randomNumber = getRandomNumber()
        moveForward(randomNumber)
    }

    private fun getRandomNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }

    private fun moveForward(number: Int) {
        if (number >= 4) {
            position++
        }
    }

    fun printCarPosition() {
        OutputView.printCarPosition(name, position)
    }
}