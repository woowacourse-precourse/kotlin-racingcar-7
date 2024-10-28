package racingcar.data

class Cars(
    private val input: String
) {
    private val cars: List<Car> = input.toCars()

    init {
        require(input.isNotEmpty())
        require(cars.map { it.name }.distinct().size == cars.size)
        require(cars.size >= MINIMUM_CAR_COUNT)
    }

    companion object {
        private const val MINIMUM_CAR_COUNT = 2
        private const val DELIMITER = ","
        private fun String.toCars() = this.split(DELIMITER).map { Car(it) }
        fun Cars.toList() = input.toCars()
    }
}