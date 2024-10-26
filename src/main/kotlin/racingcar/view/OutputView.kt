package racingcar.view

import racingcar.model.Model

object OutputView {
    fun raceStart(cars: List<Model>) {
        println("실행결과")
        for (car in cars) {
            val carName = car.name
            val carMoveCount = "-".repeat(car.moveCount)
            println("$carName : $carMoveCount")
        }
    }
}