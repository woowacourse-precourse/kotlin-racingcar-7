package racingcar.domain

import racingcar.domain.RacingCar.Companion.START_POSITION

class RacingCars(
    val racingCars: List<RacingCar>,
) {
    fun move(): RacingCars {
        val movingRacingCars = mutableListOf<RacingCar>()

        racingCars.forEach { car ->
            movingRacingCars.add(car.play())
        }

        return RacingCars(movingRacingCars)
    }

    fun getWinners(): List<String> {
        val maxPosition = racingCars.maxOf { it.position }
        if (maxPosition == START_POSITION) {
            return emptyList()
        }

        return racingCars.filter { it.position == maxPosition }.map { it.name }
    }
}
