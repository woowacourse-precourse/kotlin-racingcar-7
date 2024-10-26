package Model

object CarsFactory {
    fun createCars(names: List<String>): List<Car> {
        validateNames(names)
        return names.map { Car(it) }
    }

    private fun validateNames(names: List<String>) {
        if (names.any { it.length > 5 }) {
            throw IllegalArgumentException()
        }
    }
}
