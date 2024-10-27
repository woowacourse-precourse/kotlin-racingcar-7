package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Car

class RacingGameService {
    companion object {
        private const val FORWARD_THRESHOLD = 4
        private const val MAX_RANDOM = 9
    }

    fun moveCarRandomly(car: Car) {
        val randomVal = Randoms.pickNumberInRange(0, MAX_RANDOM)
        if (randomVal >= FORWARD_THRESHOLD) {
            car.moveForward()
        }
    }

    fun generateCarsByInput(input: String): List<Car> {
        val names = input.split(",")

        return names.map { Car(it) }
    }

    fun findWinnerNames(cars: List<Car>): List<String> {
        val maxDistance = cars.maxOf { it.distance }
        val winners = cars.filter { it.distance == maxDistance }

        return winners.map { it.name }
    }
}