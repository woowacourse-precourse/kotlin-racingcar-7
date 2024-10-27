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
        println("$cars, $tryCount")
    }

    private fun inputCars(): List<String> {
        val carsText = readLine()
        val cars = carsText.split(RacingCarDelimiters.NAME_DELIMITER)
        return cars
    }

    private fun inputTryCount(): Int = readLine().toInt()
}
