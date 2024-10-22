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

    fun getWinnersName(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}