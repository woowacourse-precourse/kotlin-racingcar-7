package racingcar

class CarRacing(names: String) {
    val carName: String

    init {
        this.carName = names
    }

    fun getNamesOfCars(): List<String> {
        return listOf(carName)
    }
}