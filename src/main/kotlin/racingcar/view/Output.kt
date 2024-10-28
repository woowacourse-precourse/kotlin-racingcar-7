package racingcar.view

import racingcar.constant.Message.INFO_ROUND_RESULT
import racingcar.constant.Message.MOVING_SYMBOL
import racingcar.constant.Message.RACE_RESULT_FORMAT
import racingcar.constant.Message.RACE_WINNER_DELIMITER
import racingcar.constant.Message.ROUND_RESULT_FORMAT
import racingcar.model.Car

class Output {
    fun showRoundResult(cars: List<Car>) {
        println(INFO_ROUND_RESULT)

        cars.forEach { car ->
            print(ROUND_RESULT_FORMAT.format(car.name))
            repeat(car.moving) {
                print(MOVING_SYMBOL)
            }
            println()
        }
        println()
    }

    fun showRaceResult(cars: List<Car>) =
        println(RACE_RESULT_FORMAT.format(cars.joinToString(RACE_WINNER_DELIMITER) { it.name }))
}