package racingcar.view

import racingcar.model.RacingCar
import racingcar.util.Constant.CAR_LOCATION_PRINTER

class OutputView {
    fun printMessage(message: String) {
        println(message)
    }

    fun printRacingResult(carList: List<RacingCar>) {
        carList.forEach { carItem ->
            println("${carItem.carName} : ${CAR_LOCATION_PRINTER.repeat(carItem.location)}")
        }
        println()
    }
}