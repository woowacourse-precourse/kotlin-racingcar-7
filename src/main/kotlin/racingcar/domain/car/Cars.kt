package racingcar.domain.car

import racingcar.domain.numbergenerator.NumberGenerator

class Cars(input: String) {
    private val registeredCars: List<Car> = registerAll(input)

    private fun registerAll(input: String) = input.split(",").map { Car(it) }.toList()

    fun lap(numberGenerator: NumberGenerator) {
        registeredCars.forEach { car ->
            car.move(numberGenerator)
        }
    }

    fun findWinners(): String {
        val maxPosition = getMaxPosition()
        val winnersName = registeredCars.filter { it.position == maxPosition }.map { it.name }.joinToString { it }
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