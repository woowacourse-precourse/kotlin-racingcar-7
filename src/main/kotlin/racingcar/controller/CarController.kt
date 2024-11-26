package racingcar.controller

import racingcar.model.Car
import racingcar.service.CarService
import racingcar.validator.InputCarsValidator
import racingcar.validator.InputTryNumberValidator
import racingcar.view.InputView
import racingcar.view.OutputView

class CarController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun run() {
        val inputCarNames = inputView.getCars()
        InputCarsValidator.validate(inputCarNames)

        val inputTryNum = inputView.getTryNumber()
        InputTryNumberValidator.validate(inputTryNum)

        val cars = CarService.createCars(inputCarNames)
        startRace(inputTryNum.toInt(), cars)

        outputView.showWinners(CarService.getWinners(cars))
    }

    private fun startRace(tryNumber: Int, cars: List<Car>) {
        repeat(tryNumber) {
            CarService.moveAll(cars)
            outputView.showStatus(CarService.getStatus(cars))
        }
    }
}