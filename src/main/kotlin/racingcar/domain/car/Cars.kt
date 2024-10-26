package racingcar.domain.car

import racingcar.domain.numbergenerator.NumberGenerator

class Cars(cars: List<Car>) {
    private val registeredCars: List<Car> = cars

    fun lap(numberGenerator: NumberGenerator) {
        registeredCars.forEach { car ->
            car.move(numberGenerator)
        }
    }

    fun findWinners(): String {
        val maxPosition = getMaxPosition()
        val winnersName =
            registeredCars
                .filter { car -> car.position == maxPosition }
                .map { car -> car.name }
                .joinToString { carName -> carName }
        return winnersName
    }

    private fun getMaxPosition() = registeredCars.maxOf { it.position }

    override fun toString(): String {
        return buildString {
            registeredCars.forEach {
                appendLine(it.toString())
            }
        }
    }

}