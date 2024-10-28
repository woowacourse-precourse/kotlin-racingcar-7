package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class RacingCar(
    private val name: String,
    private var position: Int = 0
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
}