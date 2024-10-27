package racingcar

import camp.nextstep.edu.missionutils.Console

class InputHandler {

    fun getCarsNameInput(): String {
        println(PROMPT_INPUT_RACING_CARS_NAME_MESSAGE)
        return Console.readLine()
    }

    fun getRacingCountInput(): String {
        println(PROMPT_INPUT_RACING_COUNT)
        return Console.readLine()
    }

    companion object {
        const val PROMPT_INPUT_RACING_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val PROMPT_INPUT_RACING_COUNT = "시도할 횟수는 몇 회인가요?"
    }
}