package racingcar.domain.entity

import racingcar.domain.generator.NumberGenerator
import racingcar.domain.generator.RaceRandomGenerator

class Race(
    val cars: List<Car>,
    private val numberGenerator: NumberGenerator = RaceRandomGenerator()
) {
    fun play() {
        cars.forEach { car ->
            car.tryMove(numberGenerator.generate())
        }
    }

    fun getWinnersName(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}