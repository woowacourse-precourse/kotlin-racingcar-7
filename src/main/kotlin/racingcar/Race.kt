package racingcar

class Race(
    private val numberGenerator: NumberGenerator,
    private val outputView: OutputViewInterface
) {
    private var cars: List<Car> = listOf()
    private var tryCount: Int = 0

    fun initializeRace(cars: List<Car>, tryCount: Int) {
        this.cars = cars
        this.tryCount = tryCount
    }

    fun startRace() {
        repeat(tryCount) {
            cars.forEach { car -> car.move(numberGenerator.generate()) }
            outputView.printRaceResult(cars)
        }
    }


    fun getRaceWinners(): List<Car> {
        val farthestDistance = cars.maxOf { it.position }
        return cars.filter { it.position == farthestDistance }
    }
}