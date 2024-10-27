package racingcar.service

import racingcar.model.Car
import racingcar.strategy.MoveStrategy

const val CAR_NAMES_SEPARATOR = ","
const val CAR_NAME_MAX_LENGTH = 5
const val INVALID_CAR_NAME_LENGTH_MESSAGE = "자동차 이름은 5자 이하만 가능합니다."

class RaceGameService(private val randomMoveStrategy: MoveStrategy) {
    fun setupCars(carNames: String): List<Car> {
        val cars: List<Car> = carNames.trim().split(CAR_NAMES_SEPARATOR).map { name -> Car(name) }

        if (cars.any { it.name.length > CAR_NAME_MAX_LENGTH }) {
            throw IllegalArgumentException(INVALID_CAR_NAME_LENGTH_MESSAGE)
        }

        return cars
    }

    fun performRace(cars: List<Car>) {
        for (car in cars) {
            if (randomMoveStrategy.canMove()) {
                car.moveOnce()
            }
        }
    }
}
