package racingcar.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun inputCarNames(): List<String> {
        println(INPUT_CAR_NAMES_MESSAGE)
        val carNames = Console.readLine().split(CAR_NAME_DELIMITER)
        validateCarNames(carNames)
        return carNames
    }

    fun inputGameRound(): Int {
        println(INPUT_GAME_ROUND_MESSAGE)
        val gameRound = Console.readLine().toIntOrNull() ?: throw IllegalArgumentException(ERROR_INVALID_GAME_ROUND)
        validateGameRound(gameRound)
        return gameRound
    }

    fun validateCarNames(carNames: List<String>) {
        val carNamesSet = mutableSetOf<String>()
        for (name in carNames) {
            if (name.isBlank() || name.length > 5) {
                throw IllegalArgumentException(ERROR_INVALID_CAR_NAME)
            }
            if (!carNamesSet.add(name)) {
                throw IllegalArgumentException(ERROR_DUPLICATE_CAR_NAME)
            }
        }
    }

    fun validateGameRound(gameRound: Int) {
        if (gameRound <= 0) {
            throw IllegalArgumentException(ERROR_INVALID_GAME_ROUND)
        }
    }

    private const val INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    private const val INPUT_GAME_ROUND_MESSAGE = "시도할 횟수는 몇 회인가요?"
    private const val ERROR_INVALID_CAR_NAME = "[ERROR] 자동차 이름은 5자 이하여야 합니다."
    private const val ERROR_DUPLICATE_CAR_NAME = "[ERROR] 자동차 이름은 중복될 수 없습니다."
    private const val ERROR_INVALID_GAME_ROUND = "[ERROR] 0 이상의 정수값을 입력해야 합니다."

    private const val CAR_NAME_DELIMITER = ','
}