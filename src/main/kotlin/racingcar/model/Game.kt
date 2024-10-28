package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Game(carNames: List<String>) {
    private val cars = carNames.map { Car(it) }

    fun playRound() {
        cars.forEach { car ->
            if (isMoveForward()) {
                car.move()
            }
        }
    }

    private fun isMoveForward(): Boolean {
        return Randoms.pickNumberInRange(MIN_MOVE_THRESHOLD, MAX_MOVE_THRESHOLD) >= MOVE_THRESHOLD
    }

    fun getCars(): List<Car> {
        return cars
    }

    companion object {
        const val MOVE_THRESHOLD = 4
        const val MIN_MOVE_THRESHOLD = 0
        const val MAX_MOVE_THRESHOLD = 9
    }
}