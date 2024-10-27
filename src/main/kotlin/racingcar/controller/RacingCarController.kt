package racingcar.controller

import racingcar.model.Model
import racingcar.utils.Validator
import racingcar.view.InputView
import racingcar.view.OutputView

object RacingCarController {
    fun run() {
        val inputNames = InputView.inputNames()
        Validator.validateInputNames(inputNames)
        val round = InputView.inputRound().toInt()
        Validator.validateInputRound(round.toString())

        val cars = inputNames.split(",").map { it.trim() }.map { Model(it) }

        raceStrat(cars, round)
    }

    fun raceStrat(cars: List<Model>, round: Int) {
        println("실행결과")
        repeat(round) {
            RandomCarMove(cars)
            OutputView.outputRaceStatus(cars)
            println()
        }

    }

    fun RandomCarMove(cars: List<Model>) {
        for (car in cars) {
            if (car.canMoveForward()) car.moveCount++
        }
    }

}