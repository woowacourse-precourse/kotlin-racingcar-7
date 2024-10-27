package racingcar.controller

import racingcar.model.RacingCar
import racingcar.view.InputView
import camp.nextstep.edu.missionutils.Randoms
import racingcar.constant.PrintMessage
import racingcar.view.OutputView
import racingcar.constant.ErrorMessage
import racingcar.constant.GameSettings

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
        if (validateRacingCarNames(racingCarNames)) {
            return racingCarNames.map { racingCarName ->
                RacingCar(racingCarName)
            }
        }
        throw IllegalArgumentException(ErrorMessage.FAIL_CREATE_RACINGCAR)
    }

    private fun parseRacingCarNames(input: String) = input.split(GameSettings.PARSE_DELIMITER).map { it.trim() }

    private fun validateRacingCarNames(racingCarNames: List<String>): Boolean {
        return when {
            hasDuplicateNames(racingCarNames) -> throw IllegalArgumentException(ErrorMessage.HAS_DUPLICATE_NAMES)
            isNameEmpty(racingCarNames) -> throw IllegalArgumentException(ErrorMessage.IS_NAME_EMPTY)
            isOverMaxLength(racingCarNames) -> throw IllegalArgumentException(ErrorMessage.IS_OVER_MAX_LENGTH)
            else -> true
        }
    }

    private fun hasDuplicateNames(names: List<String>) = names.size != names.distinct().size

    private fun isNameEmpty(names: List<String>) = names.any { name -> name.isEmpty() }

    private fun isOverMaxLength(names: List<String>) = names.any { name -> name.length > GameSettings.MAX_LENGTH }

    fun convertToAttemptCount(input: String): Int {
        if (validateAttemptCount(input)) {
            return input.toInt()
        }
        throw IllegalArgumentException(ErrorMessage.FAIL_CONVERT_TO_ATTEMPT_COUNT)
    }

    private fun validateAttemptCount(attemptCount: String): Boolean  {
        return when {
            isNonNumber(attemptCount) -> throw IllegalArgumentException(ErrorMessage.IS_NON_NUMBER)
            isNonPositiveNumber(attemptCount) -> throw IllegalArgumentException(ErrorMessage.IS_NON_POSITIVE_NUMBER)
            else -> true
        }
    }

    private fun isNonNumber(input: String) = input.toIntOrNull() == null

    private fun isNonPositiveNumber(input: String) = input.toInt() <= GameSettings.NON_POSITIVE_STANDARD

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