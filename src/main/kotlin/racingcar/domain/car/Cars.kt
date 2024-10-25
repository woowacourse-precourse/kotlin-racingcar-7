package racingcar.domain.car

import racingcar.domain.numbergenerator.NumberGenerator

class Cars(input: String) {
    private val registeredCars: List<Car> = registerAll(input)

    private fun registerAll(input: String) = input.split(",").map { Car(it) }.toList()

    fun lap(numberGenerator: NumberGenerator) {
        registeredCars.forEach { car ->
            val number = numberGenerator.generateNumber()
            if (isAvailMove(number)) car.move()
        }
    }

    private fun isAvailMove(number: Int) = number >= 4

    override fun toString(): String {
        return buildString {
            registeredCars.forEach {
                appendLine(it.toString())
            }
        }
    }
}