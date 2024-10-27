package Model

object CarsFactory {
    fun createCars(names: List<String>): List<Car> {
        validateNames(names)
        return names.map { Car(it) }
    }

    private fun validateNames(names: List<String>) {
        require(names.size > 1) {
            throw IllegalArgumentException()
        }
        require(names.all { it.isNotBlank() }) {
            throw IllegalArgumentException()
        }
        require(names.all { it.length <= 5 }) {
            throw IllegalArgumentException()
        }
        require(names.distinct().size == names.size) {
            throw IllegalArgumentException()
        }
    }
}
