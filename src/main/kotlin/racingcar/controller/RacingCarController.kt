package racingcar.controller

import racingcar.model.RacingCar
import racingcar.view.InputView
import camp.nextstep.edu.missionutils.Randoms

class RacingCarController {
    private val inputView = InputView()

    fun run() {
        val racingCarNameInput = inputView.inputRacingCarName()
        val attemptCountInput = inputView.inputAttemptCount()

        val racingCars = createRacingCars(racingCarNameInput)
        val attemptCount = convertToAttemptCount(attemptCountInput)
        val randomNumber = createRandomNumber()
    }

    fun createRacingCars(input: String): List<RacingCar> {
        val racingCarNames = parseRacingCarNames(input)
        if (validateRacingCarNames(racingCarNames)) {
            return racingCarNames.map { racingCarName ->
                RacingCar(racingCarName)
            }
        }
        throw IllegalArgumentException("레이싱카 생성이 실패했습니다.")
    }

    private fun parseRacingCarNames(input: String) = input.split(",").map { it.trim() }

    private fun validateRacingCarNames(racingCarNames: List<String>): Boolean {
        return when {
            hasDuplicateNames(racingCarNames) -> throw IllegalArgumentException("자동차 이름은 중복될 수 없습니다.")
            isNameEmpty(racingCarNames) -> throw IllegalArgumentException("자동차의 이름이 입력되지 않았습니다.")
            isOverMaxLength(racingCarNames) -> throw IllegalArgumentException("입력하신 이름의 길이가 5글자를 초과하였습니다.")
            else -> true
        }
    }

    private fun hasDuplicateNames(names: List<String>) = names.size != names.distinct().size

    private fun isNameEmpty(names: List<String>) = names.any { name -> name.isEmpty() }

    private fun isOverMaxLength(names: List<String>) = names.any { name -> name.length > 5 }

    fun convertToAttemptCount(input: String): Int {
        if (validateAttemptCount(input)) {
            return input.toInt()
        }
        throw IllegalArgumentException("입력하신 시도 횟수가 검증에 실패하였습니다.")
    }

    private fun validateAttemptCount(attemptCount: String): Boolean  {
        return when {
            isNotNumber(attemptCount) -> throw IllegalArgumentException("입력하신 횟수는 숫자가 아닙니다.")
            isNonPositiveNumber(attemptCount) -> throw IllegalArgumentException("입력하신 숫자는 양수가 아닙니다.")
            else -> true
        }
    }

    private fun isNotNumber(input: String) = input.toIntOrNull() == null

    private fun isNonPositiveNumber(input: String) = input.toInt() <= 0

    private fun createRandomNumber() = Randoms.pickNumberInRange(0, 9)

    fun moveForward(racingCars: List<RacingCar>, randomNumber: Int) {
        if (isMoveForwardPossible(randomNumber)) {
            racingCars.forEach { car->
                car.movementDistance ++
            }
        }
    }

    private fun isMoveForwardPossible(number: Int) = number >= 4

}