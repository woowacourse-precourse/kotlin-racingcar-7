package Controller

import Model.CarsFactory
import Model.MoveStrategy
import Model.Race
import View.InputView
import View.ResultView

class RacingGameController(private val moveStrategy: MoveStrategy) {

    fun playGame() {
        try {
            val cars = CarsFactory.createCars(InputView.getCarNames())
            val rounds = InputView.getRounds()
            val race = Race(cars, rounds, moveStrategy)

            println("\n실행 결과")
            val raceProgress = race.startRace()
            raceProgress.forEach { ResultView.printRaceProgress(it) }
            ResultView.printWinners(race.findWinners())

        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException()
        }
    }
}