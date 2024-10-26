package racingcar

import racingcar.domain.Car

class RacingCars(
    val cars: List<Car>,
) {
    fun move(): RacingCars {
        val movingCars = mutableListOf<Car>()

        cars.forEach { car ->
            movingCars.add(car.play())
        }

        return RacingCars(movingCars)
    }

    fun getWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}
