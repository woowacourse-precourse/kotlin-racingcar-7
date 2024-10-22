package racingcar

class Race(
    val cars: List<Car>,
    private val numberGenerator: NumberGenerator = RaceRandomGenerator()
) {
    fun play() {
        cars.forEach { car ->
            car.tryMove(numberGenerator.generate())
        }
    }
}