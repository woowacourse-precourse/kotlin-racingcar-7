package racingcar.model

import racingcar.constants.Constants.COMMA


class Race(carNames: String, val tryCount: Int) {
    val carList = carNames.split(COMMA).map { Car(it) }

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
