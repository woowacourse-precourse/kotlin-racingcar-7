package racingcar.domain.usecase

import racingcar.domain.entity.Car

class GetWinnersUseCase {
    fun getWinnersName(cars: List<Car>): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}