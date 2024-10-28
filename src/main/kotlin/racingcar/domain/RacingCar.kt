package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class RacingCar(
    private val name: String,
    private val position: Int = 0
) {
    fun play() {
        val randomNumber = getRandomNumber()
    }

    private fun getRandomNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}