package racingcar.model

import racingcar.utils.Constants
import racingcar.utils.Validator


class Race(private val cars: List<Car>) {

    init {
        Validator.validateCarNames(cars)
    }
    fun raceRound(randomValueProvider: () -> Int) {
        cars.forEach { car ->
            val num = randomValueProvider()
            if (num >= Constants.MOVE_THRESHOLD) car.move()
        }
    }

    fun findWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}
