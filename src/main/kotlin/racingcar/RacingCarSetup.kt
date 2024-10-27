package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

/**
 * 자동차 경주 게임 시작 전 세팅을 해준다.
 * 자동차 이름과 시도할 횟수를 입력 받고 사용할 데이터를 반환한다.
 */
class RacingCarSetup {
    init {
        setUp()
    }

    private fun setUp() {
        println(RacingCarText.INPUT_CAR_NAME)
        val cars = inputCars()
        println(RacingCarText.INPUT_TRY_COUNT)
        val tryCount = inputTryCount()
        println("$cars, $tryCount") // TODO 삭제 예정
    }

    private fun inputCars(): List<String> {
        val carsText = readLine()
        val cars = carsText.split(RacingCarDelimiters.NAME_DELIMITER)
        return cars
    }

    private fun inputTryCount(): Int {
        val tryCount =
            readLine().toIntOrNull()
                ?: throw IllegalArgumentException(TRY_COUNT_IS_NOT_NUMBER_EXCEPTION)
        return tryCount
    }

    companion object {
        private const val TRY_COUNT_IS_NOT_NUMBER_EXCEPTION = "시도할 횟수는 숫자만 입력 받을 수 있습니다."
    }
}
