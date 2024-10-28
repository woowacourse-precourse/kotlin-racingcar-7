package racingcar.view

import racingcar.model.Car

class OutputView {
    fun printRoundResult(cars: List<Car>) {
        cars.forEach { println(it) }
        println()
    }
}