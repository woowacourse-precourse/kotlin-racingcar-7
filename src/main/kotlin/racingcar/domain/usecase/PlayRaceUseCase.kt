package racingcar.domain.usecase

import racingcar.domain.entity.Car
import racingcar.domain.generator.NumbersGenerator

class PlayRaceUseCase(
    private val numbersGenerator: NumbersGenerator
) {
    fun execute(cars: List<Car>) {
        cars.forEach { car ->
            car.tryMove(numbersGenerator.generate())
        }
    }
}