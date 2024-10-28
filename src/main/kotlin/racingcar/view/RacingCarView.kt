package racingcar.view

import racingcar.model.Car

interface RacingCarView {
    fun getUserInput(message: String): String
    fun displayRaceRound(cars: List<Car>)
    fun displayWinners(cars: List<Car>)
}