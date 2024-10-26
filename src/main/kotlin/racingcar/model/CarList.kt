package racingcar.model

class CarList {
    private val cars = mutableListOf<Car>()
    fun addCar(car: Car) {
        cars.add(car)
    }

    fun getCar(index: Int): Car {
        return cars[index]
    }
}