package racingcar.model

import racingcar.utils.ErrorMessages


class Race(val cars: List<Car>, val numberOfRounds: Int) {

    init {
        if (cars.size != cars.distinct().size) {
            throw IllegalArgumentException(ErrorMessages.NAME_DUPLICATE_ERROR)
        }
    }
    fun raceRound(randomValueProvider: () -> Int) {
        cars.forEach { car ->
            if (randomValueProvider() >= 4) car.move()
        }
    }

    fun findWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}
