package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Car

class RacingCarGame(names: List<String>) {

    private var cars: List<Car> = names.map { Car(it, 0) }

    fun moveCars() {
        cars = cars.map { car ->
            movedCar(car)
        }
    }

    private fun movedCar(car: Car) : Car {
        val move = Randoms.pickNumberInRange(0, 9)
        return if (move >= 4) {
            car.copy(moveCount = car.moveCount + 1)
        } else {
            car
        }
    }

    fun printResults() {
        cars.forEach { println("${it.name} : ${"-".repeat(it.moveCount)}") }
    }

    fun printWinners() {
        println("최종 우승자 : ${getWinners().joinToString { it.name }}")
    }

    private fun getWinners() : List<Car> {
        val maxCount = cars.maxOf { it.moveCount }
        return cars.filter { it.moveCount == maxCount }
    }
}