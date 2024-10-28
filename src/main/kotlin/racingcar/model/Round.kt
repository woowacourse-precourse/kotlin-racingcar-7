package racingcar.model

class Round(private val numberGenerator: NumberGenerator) {
    companion object {
        private const val MIN_FORWARD_VALUE = 4
    }

    fun play(cars: List<Car>) {
        cars.forEach { car ->
            if (numberGenerator.generate() >= MIN_FORWARD_VALUE) {
                car.moveForward()
            }
        }
    }
}
