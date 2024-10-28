package racingcar.model

data class Cars(val carNames: List<String>) {
    val cars: List<Car> = carNames.map { Car(it) }
}
