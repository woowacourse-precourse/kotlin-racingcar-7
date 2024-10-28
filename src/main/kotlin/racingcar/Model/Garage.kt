package racingcar.Model

private const val CAR_NAME_SPLIT_POINT = ','

class Garage(nameOfCars: String) {
    val carsInGarage: List<Car> = nameOfCars.split(CAR_NAME_SPLIT_POINT)
        .map { name -> Car(name.trim()) }
}