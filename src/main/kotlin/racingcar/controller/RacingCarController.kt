package racingcar.controller

import racingcar.domain.*
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController(
    val inputView: InputView,
    val outputView: OutputView,
    val randomNumberImpl: RandomNumberImpl
) {

    fun run() {
        val cars = getRacingCars()
        val lapCount = getLapCount()

        startRacing(cars, lapCount)
        getWinners(cars)
    }

    private fun getRacingCars(): List<Car> {
        val stringCarNames = inputView.inputCarNames()
        val carNamesList = stringCarNames.trim().split(",")
        val cars = CarFactory.createCars(carNamesList, randomNumberImpl)
        return cars
    }

    private fun getLapCount(): Int {
        val stringLapCount = inputView.inputLapCount()
        val lapCount = Lap(stringLapCount).count
        return lapCount
    }

    private fun startRacing(cars: List<Car>, lapCount: Int) {
        outputView.printRacingResultMessage()
        repeat(lapCount) {
            cars.forEach { car ->
                car.moveToForward()
                outputView.printRacingResult(car.carName, car.distance)
            }
            outputView.newLine()
        }
    }

    private fun getWinners(cars: List<Car>) {
        val winner = Winner(cars).getWinner()
        outputView.printRacingWinner(winner)
    }
}
