package racingcar.service

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Car

class RacingGameService {
    fun moveCarRandomly(car: Car) {
        val randomVal = Randoms.pickNumberInRange(0, 9)
        if (randomVal >= 4) {
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