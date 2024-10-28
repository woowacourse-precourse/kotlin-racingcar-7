package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

/**
 * 자동차 경주 게임 시작 전 세팅을 해준다.
 * 자동차 이름과 시도할 횟수를 입력 받고 사용할 데이터를 반환한다.
 */
class GameInitializer {
    lateinit var cars: List<Car>
        private set
    var gameCount = 0
        private set

    init {
        setup()
    }

    private fun setup() {
        println(InputOutputText.INPUT_CAR_NAME)
        cars = setupCars()
        println(InputOutputText.INPUT_TRY_COUNT)
        gameCount = setupGameCount()
    }

    private fun setupCars(): List<Car> {
        val carInput = readLine()
        val carStringList = splitCarInput(carInput).validateCarNaming()
        val cars = carStringList.asCar()
        return cars
    }

    private fun setupGameCount(): Int {
        val gameCountInput = readLine()
        val gameCountInt = gameCountInput.toIntAndValidateGameCount()
        return gameCountInt
    }

    private fun splitCarInput(carInput: String): List<String> = carInput.split(Delimiters.NAME_DELIMITER)

    private fun List<String>.validateCarNaming(): List<String> {
        this.forEach {
            if (it.length > CAR_NAME_MAX_LENGTH) {
                throw IllegalArgumentException(CAR_NAME_MAX_LENGTH_EXCEPTION)
            }
        }
        return this
    }

    private fun String.toIntAndValidateGameCount(): Int {
        val gameCount =
            this.toIntOrNull()
                ?: throw IllegalArgumentException(TRY_COUNT_IS_NOT_NUMBER_EXCEPTION)
        return gameCount
    }

    companion object {
        private const val CAR_NAME_MAX_LENGTH = 5
        private const val CAR_NAME_MAX_LENGTH_EXCEPTION = "자동차 이름은 5자 이하만 가능 합니다."
        private const val TRY_COUNT_IS_NOT_NUMBER_EXCEPTION = "시도할 횟수는 숫자만 입력 받을 수 있습니다."
    }
}
