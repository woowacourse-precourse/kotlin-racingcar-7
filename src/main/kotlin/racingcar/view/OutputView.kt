package racingcar.view

import racingcar.model.Model

object OutputView {
    fun outputRaceStatus(cars: List<Model>) {
        for (car in cars) {
            val carName = car.name
            val carMoveCount = "-".repeat(car.moveCount)
            println("$carName : $carMoveCount")
        }
    }
}