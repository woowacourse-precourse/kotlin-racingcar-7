package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

/**
 * 자동차 경주 게임 시작 전 세팅을 해준다.
 * 자동차 이름과 시도할 횟수를 입력 받고 사용할 데이터를 반환한다.
 */
class RacingCarSetup {
    var cars: List<Car> = emptyList()
        private set
    var tryCount: Int = 0
        private set

    init {
        setUp()
    }

    private fun setUp() {
        println(RacingCarText.INPUT_CAR_NAME)
        cars = inputCars().asCar()
        println(RacingCarText.INPUT_TRY_COUNT)
        tryCount = inputTryCount()
    }

    private fun inputCars(): List<String> {
        val carsText = readLine()
        val cars =
            carsText
                .split(RacingCarDelimiters.NAME_DELIMITER)
                .validateCarNaming()
        return cars
    }

    private fun inputTryCount(): Int {
        val tryCount =
            readLine().toIntOrNull()
                ?: throw IllegalArgumentException(TRY_COUNT_IS_NOT_NUMBER_EXCEPTION)
        return tryCount
    }

    private fun List<String>.validateCarNaming(): List<String> {
        this.forEach {
            if (it.length > CAR_NAME_MAX_LENGTH) {
                throw IllegalArgumentException(CAR_NAME_MAX_LENGTH_EXCEPTION)
            }
        }
        return this
    }

    companion object {
        private const val CAR_NAME_MAX_LENGTH = 5
        private const val CAR_NAME_MAX_LENGTH_EXCEPTION = "자동차 이름은 5자 이하만 가능 합니다."
        private const val TRY_COUNT_IS_NOT_NUMBER_EXCEPTION = "시도할 횟수는 숫자만 입력 받을 수 있습니다."
    }
}
