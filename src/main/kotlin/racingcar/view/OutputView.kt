package racingcar.view

import racingcar.model.Car

object OutputView{
    fun displayCarStatus(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }
}