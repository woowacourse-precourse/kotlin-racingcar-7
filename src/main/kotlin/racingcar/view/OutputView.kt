package racingcar.view

import racingcar.model.RacingCar

class OutputView {
    fun printMessage(message: String) {
        println(message)
    }

    fun printRacingResult(carList: List<RacingCar>) {
        carList.forEach { carItem ->
            println("${carItem.carName} : ${carItem.location}")
        }
        println()
    }
}