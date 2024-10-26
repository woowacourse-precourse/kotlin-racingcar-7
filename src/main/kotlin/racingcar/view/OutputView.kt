package racingcar.view

import racingcar.model.Car

object OutputView {
    fun displayCarPositions(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
    }
}
