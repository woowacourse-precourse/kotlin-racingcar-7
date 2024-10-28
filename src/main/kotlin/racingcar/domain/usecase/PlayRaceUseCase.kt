package racingcar.domain.usecase

import racingcar.domain.entity.Car
import racingcar.domain.generator.NumberGenerator
import racingcar.domain.generator.RaceRandomGenerator

class PlayRaceUseCase(
    private val numberGenerator: NumberGenerator = RaceRandomGenerator()
) {
    fun execute(cars: List<Car>) {
        cars.forEach { car ->
            car.tryMove(numberGenerator.generate())
        }
    }
}