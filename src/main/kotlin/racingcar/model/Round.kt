package racingcar.model

class Round(private val numberGenerator: NumberGenerator) {
    fun play(cars: List<Car>) {
        cars.forEach { car ->
            if (numberGenerator.generate() >= MIN_FORWARD_VALUE) {
                car.moveForward()
            }
        }
    }

    companion object {
        private const val MIN_FORWARD_VALUE = 4
    }
}
