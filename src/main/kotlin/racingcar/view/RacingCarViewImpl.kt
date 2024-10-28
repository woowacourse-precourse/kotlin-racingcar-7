package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Car
import racingcar.util.ConstantsUtil.MESSAGE_RACING_WINNERS_FORMAT

class RacingCarViewImpl : RacingCarView {

    override fun getUserInput(message: String): String {
        println(message)
        return Console.readLine()
    }

    override fun displayRaceRound(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }

    override fun displayWinners(cars: List<Car>) {
        println(formatWinners(cars))
    }

    private fun formatWinners(cars: List<Car>): String {
        val winners = cars.joinToString(", ") { it.name }
        return MESSAGE_RACING_WINNERS_FORMAT.format(winners)
    }
}