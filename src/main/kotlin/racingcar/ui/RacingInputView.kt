package racingcar.ui

import camp.nextstep.edu.missionutils.Console

class RacingInputView {

    fun guideInputCarsName() = println(GUIDE_INPUT_CARS_NAME_MESSAGE)

    fun guideInputRaceCount() = println(GUIDE_INPUT_RACE_COUNT_MESSAGE)

    fun getCarsName() = Console.readLine()

    fun getRaceCount(): Int {
        val count = Console.readLine().toIntOrNull()
        requireNotNull(count) { println(INPUT_INTEGER_ERROR_MESSAGE) }
        return count
    }

    companion object {
        private const val GUIDE_INPUT_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val GUIDE_INPUT_RACE_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
        private const val INPUT_INTEGER_ERROR_MESSAGE = "정수를 입력해주세요"
    }
}