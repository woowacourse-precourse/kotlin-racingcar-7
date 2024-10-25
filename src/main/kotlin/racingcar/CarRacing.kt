package racingcar

class CarRacing(names: String) {
    val cars: List<Car>

    init {
        this.cars = names.split(",").map { Car(it) }
    }

    fun getNamesOfCars(): List<String> {
        return cars.map { it.name }
    }
}