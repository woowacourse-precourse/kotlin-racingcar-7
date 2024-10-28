package racingcar.view

import racingcar.model.Car

class ResultView {

    fun printRoundResult(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.distance)}")
        }
        println()
    }
}