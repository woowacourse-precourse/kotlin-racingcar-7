package racingcar.feature

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Car

class RacingCarGame(names: List<String>) {

    private var cars: List<Car> = names.map { Car(it, DEFAULT_MOVE_COUNT) }

    fun moveCars() {
        cars = cars.map { car ->
            movedCar(car)
        }
    }

    private fun movedCar(car: Car): Car {
        val move = Randoms.pickNumberInRange(0, 9)
        return if (move >= MOVING_FORWARD) {
            car.copy(moveCount = car.moveCount + 1)
        } else {
            car
        }
    }

    fun printResults() {
        cars.forEach { println("${it.name} : ${MOVE_SYMBOL.repeat(it.moveCount)}") }
    }

    fun printWinners() {
        println("${FINAL_WINNER}${getWinners().joinToString { it.name }}")
    }

    private fun getWinners(): List<Car> {
        val maxCount = cars.maxOf { it.moveCount }
        return cars.filter { it.moveCount == maxCount }
    }

    companion object {
        private const val DEFAULT_MOVE_COUNT: Int = 0
        private const val MOVING_FORWARD: Int = 4
        private const val MOVE_SYMBOL: String = "-"
        private const val FINAL_WINNER: String = "최종 우승자 : "
    }
}