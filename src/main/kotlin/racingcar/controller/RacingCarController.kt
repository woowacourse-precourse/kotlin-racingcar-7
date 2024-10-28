package racingcar.controller

import racingcar.view.ErrorView
import racingcar.view.InputView
import racingcar.view.OutputView
import racingcar.model.Car
import racingcar.utils.RandomUtils
import racingcar.utils.ValidateCarNames
import racingcar.utils.ValidateAttempts

class RacingCarController {
    private val inputView = InputView
    private val errorView = ErrorView
    private val outputView = OutputView
    private val validateCarNames = ValidateCarNames
    private val validateAttempts = ValidateAttempts
    private val cars = mutableListOf<Car>()

    fun start() {
        try {
            val carNames = getCarNames()
            val numberOfAttempts = getNumberOfAttempts()

            initializeCars(carNames.toList())
            playRace(numberOfAttempts)

            val winners = findWinners()
            outputView.displayWinners(winners)

        } catch (e: IllegalArgumentException) {
            errorView.errorMessage(e.message ?: "오류가 발생했습니다.")
            throw e
        }
    }

    private fun getCarNames(): Collection<String> {
        val input = inputView.askForCarNames()

        val carNames = input.split(",").map { it.trim() }

        validateCarNames.checkIfEmpty(carNames)
        validateCarNames.checkLength(carNames)

        return validateCarNames.checkDuplicates(carNames)
    }

    private fun getNumberOfAttempts(): Int {
        val input = inputView.askForNumberOfAttempts()

        val numberOfAttempts = validateAttempts.checkIfEmpty(input)
        validateAttempts.validatePositiveAttempts(numberOfAttempts)

        return numberOfAttempts
    }

    private fun initializeCars(carNames: List<String>) {
        carNames.forEach { name -> cars.add(Car(name)) }
    }

    private fun playRace(attempts: Int) {
        repeat(attempts) {
            moveCars()
            outputView.displayCarStatus(cars)
        }
    }

    private fun moveCars() {
        cars.forEach { car ->
            car.move(RandomUtils.canMove())
        }
    }

    private fun findWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}