package racingcar.model

class Game(carNames: List<String>) {
    private val cars = carNames.map { Car(it) }

    fun playRound() {
        cars.forEach { car ->

        }
    }
}