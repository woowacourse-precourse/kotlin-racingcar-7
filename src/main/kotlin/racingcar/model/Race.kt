package racingcar.model


class Race(carNames: String, private val tryCount: Int) {
    val carList = carNames.split(',').map { Car(it) }

    fun start() {
        repeat(tryCount) {
            carList.forEach { car ->
                val randomNumber = randomNumber()
                car.move(randomNumber > 3)
            }
        }
    }

    fun getWinners(): List<String> {
        val maxMoveCount = carList.maxOf { it.getMoveCount() }
        return carList.filter { it.getMoveCount() == maxMoveCount }.map { it.carName }
    }
}
