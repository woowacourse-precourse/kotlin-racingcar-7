package racingcar

class Round(carNames: List<String>) {
    private var cars: MutableList<Car> = carNames.map { Car(it) }.toMutableList()

}