package racingcar.Controller

import racingcar.Model.Garage
import racingcar.Model.Race
import racingcar.Model.RandomNumber
import racingcar.Model.RandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

class RaceManager {
    val inputView = InputView()
    val outputView = OutputView()

    fun startRace() {
        val nameOfCars = inputView.getNameOfCars().toString()
        val tryCounts = inputView.getTryCounts().toString().toInt()

        playRace(nameOfCars, tryCounts)
    }

    private fun playRace(nameOfCars: String, tryCounts: Int) {
        val carsInGarage = Garage(nameOfCars).carsInGarage
        val randomNumberGenerator = RandomNumber
        val race = Race(carsInGarage)

        println()
        outputView.printRoundMessage()
        repeat(tryCounts) {
            race.playOneRound(randomNumberGenerator)
            outputView.printCurrentRound(carsInGarage)
            println()
        }

        val winner = race.getWinner()
        outputView.printWinner(winner)
    }
}