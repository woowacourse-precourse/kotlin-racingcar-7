package racingcar

class GuideOutput {
    fun guideInputCarsName() = println(GUIDE_INPUT_CARS_NAME_MESSAGE)

    fun guideInputRaceCount() = println(GUIDE_INPUT_RACE_COUNT_MESSAGE)

    fun guideExecuteResult() = println(GUIDE_EXECUTE_RESULT_MESSAGE)

    companion object {
        private const val GUIDE_INPUT_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val GUIDE_INPUT_RACE_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
        private const val GUIDE_EXECUTE_RESULT_MESSAGE = "\n실행 결과"
    }
}