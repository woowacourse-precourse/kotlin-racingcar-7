package racingcar.controller

import racingcar.model.Model
import racingcar.utils.Validator
import racingcar.view.InputView
import racingcar.view.OutputView

object RacingCarController {
    fun run() {
        val cars = initializeCars()
        val round = initializeRounds()

        raceStart(cars, round)

        val winners = identifyRaceWinners(cars)
        OutputView.outputWinners(winners)
    }

    fun initializeCars(): List<Model> {
        val inputNames = InputView.inputNames()
        Validator.validateInputNames(inputNames)
        return inputNames.split(",").map { it.trim() }.map { Model(it) }
    }

    fun initializeRounds(): Int {
        val round = InputView.inputRound().toInt()
        Validator.validateInputRound(round.toString())
        return round
    }

    fun raceStart(cars: List<Model>, round: Int) {
        println()
        println("실행결과")
        repeat(round) {
            randomCarMove(cars)
            OutputView.outputRaceStatus(cars)
            println()
        }

    }

    fun randomCarMove(cars: List<Model>) {
        for (car in cars) {
            car.moveCountUp()
        }
    }

    fun identifyRaceWinners(cars: List<Model>): List<Model> {
        val max = cars.maxOf { it.moveCount }
        val winners = cars.filter { it.moveCount == max }
        return winners
    }

}