package Controller

import Model.CarsFactory
import Model.MoveStrategy
import Model.startRace
import Model.findWinner
import View.*

class RacingGameController(private val moveStrategy: MoveStrategy) {
    fun playGame() {
        try {
            val cars = CarsFactory.createCars(InputView.getCarNames())
            val rounds = InputView.getRounds()
            val raceProgress = startRace(cars, rounds, moveStrategy)

            println("\n실행 결과")
            raceProgress.forEach { ResultView.printRaceProgress(it) }
            ResultView.printWinners(findWinner(cars))

        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException()
        }
    }
}
