package racingcar.controller

import racingcar.model.RacingCar
import racingcar.view.InputView
import camp.nextstep.edu.missionutils.Randoms
import racingcar.constant.PrintMessage
import racingcar.view.OutputView
import racingcar.constant.ErrorMessage
import racingcar.constant.GameSettings
import racingcar.validator.AttemptCountValidator
import racingcar.validator.RacingCarNameValidator

class RacingCarController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        val racingCarNameInput = inputView.inputRacingCarName()
        val racingCars = createRacingCars(racingCarNameInput)

        val attemptCountInput = inputView.inputAttemptCount()
        val attemptCount = convertToAttemptCount(attemptCountInput)

        printRaceResult(racingCars, attemptCount)

        val finalWinners = getFinalWinner(racingCars)

        outputView.printFinalWinner(finalWinners)
    }

    fun createRacingCars(input: String): List<RacingCar> {
        val racingCarNames = parseRacingCarNames(input)
        if (RacingCarNameValidator.validate(racingCarNames)) {
            return racingCarNames.map { racingCarName ->
                RacingCar(racingCarName)
            }
        }
        throw IllegalArgumentException(ErrorMessage.FAIL_CREATE_RACINGCAR)
    }

    private fun parseRacingCarNames(input: String) = input.split(GameSettings.PARSE_DELIMITER).map { it.trim() }

    fun convertToAttemptCount(input: String): Int {
        if (AttemptCountValidator.validate(input)) {
            return input.toInt()
        }
        throw IllegalArgumentException(ErrorMessage.FAIL_CONVERT_TO_ATTEMPT_COUNT)
    }

    private fun createRandomNumber() = Randoms.pickNumberInRange(GameSettings.RANDOM_NUMBER_MIN, GameSettings.RANDOM_NUMBER_MAX)

    private fun moveForward(racingCars: List<RacingCar>) {
        racingCars.forEach { car->
            val randomNumber = createRandomNumber()
            if (isMoveForwardPossible(randomNumber)) {
                car.movementDistance ++
            }
        }
    }

    private fun isMoveForwardPossible(number: Int) = number >= GameSettings.MOVE_FORWARD_STANDARD

    private fun printRaceResult(racingCars: List<RacingCar>, attemptCount: Int) {
        outputView.printRaceResult()
        repeat(attemptCount) {
            moveForward(racingCars)
            racingCars.forEach { car ->
                printRacingCarMovementDistance(car)
            }
            outputView.printBlank()
        }
    }

    private fun printRacingCarMovementDistance(racingCar: RacingCar) {
        val movementDistance = racingCar.movementDistance
        println("${racingCar.racingCarName} : ${PrintMessage.MOVE_SYMBOL.repeat(movementDistance)}")
    }

    private fun getFinalWinner(racingCars: List<RacingCar>): List<String> {
        val maxMovementDistance = getMaxMovementDistance(racingCars)
        return racingCars
            .filter { it.movementDistance == maxMovementDistance }
            .map { it.racingCarName }

    }

    private fun getMaxMovementDistance(racingCars: List<RacingCar>) = racingCars.maxOf { it.movementDistance }

}