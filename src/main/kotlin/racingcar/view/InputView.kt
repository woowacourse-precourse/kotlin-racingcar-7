package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun inputCarNames(): List<String> {
        println(INPUT_CAR_NAMES_MESSAGE)
        return Console.readLine().split(CAR_NAME_DELIMITER)
    }

    fun inputGameRound(): Int {
        println(INPUT_GAME_ROUND)
        return Console.readLine().toIntOrNull() ?: throw IllegalArgumentException(ERROR_INVALID_GAME_ROUND)
    }

    companion object {
        private const val INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val INPUT_GAME_ROUND = "시도할 횟수는 몇 회인가요?"

        private const val CAR_NAME_DELIMITER = ','

        private const val ERROR_INVALID_GAME_ROUND = "[ERROR] 0 이상의 정수값을 입력해야 합니다."
    }
}