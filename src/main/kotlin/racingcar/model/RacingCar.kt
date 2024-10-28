package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.util.ConstantsUtil.MAX_RANDOM_NUMBER
import racingcar.util.ConstantsUtil.MIN_RANDOM_NUMBER

class RacingCar(
    private val cars: List<Car>
) {
    fun playRound() {
        cars.forEach { car ->
            if (isMove()) {
                car.move()
            }
        }
    }

    private fun isMove(): Boolean {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= 4
    }

    fun findWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }
}