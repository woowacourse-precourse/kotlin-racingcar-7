package racingcar.model

data class Race(
    val cars: MutableList<Car> = mutableListOf()
) {
    fun addCar(carNames: List<String>) = carNames.forEach { name -> cars.add(Car(name)) }
    fun maxMoving() = cars.maxOf { it.moving }
}