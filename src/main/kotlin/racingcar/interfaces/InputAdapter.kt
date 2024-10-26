package racingcar.interfaces

import racingcar.domain.Car

class InputAdapter (
    private val carNames: String,
    private val matches: String
) {
    fun splitCarName(): List<String> {
        val cars = carNames.split(DELIMITER)
        return cars
    }

    fun validateCarName(cars: List<String>): List<String> {
        val racingCars = mutableListOf<String>()
        for (car in cars) {
            when {
                car.length > 5 -> throw IllegalArgumentException(INPUT_ERROR_MSG + CARNAME_LESS_THAN_5_EXCEPTION_MSG)
                car.isEmpty() -> throw IllegalArgumentException(INPUT_ERROR_MSG + CARNAME_EMPTY_EXCEPTION_MSG)
                car.isBlank() -> throw IllegalArgumentException(INPUT_ERROR_MSG + CARNAME_WHITESPACE_EXCEPTION_MSG)
                racingCars.contains(car) -> throw IllegalArgumentException(INPUT_ERROR_MSG + CARNAME_SAME_CARNAME_EXCEPTION_MSG)
            }

            racingCars.add(car)
        }
        if (racingCars.size == 1) throw IllegalArgumentException(INPUT_ERROR_MSG +CARNAME_ONE_EXCEPTION_MSG)
        return racingCars
    }

    fun changeTypeOfCar(racingCars: List<String>): List<Car> {
        val readyRacingCars: List<Car> = racingCars.map{ Car(it) }
        return readyRacingCars
    }

    fun changeTypeOfMatches(): Int {
        validateMatches()
        return matches.toInt()
    }

    fun validateMatches(): Boolean {
        when {
            matches.toIntOrNull() == null -> throw IllegalArgumentException(INPUT_ERROR_MSG + MATCHES_NOT_INT_EXCEPTION_MSG)
            matches.toInt() == 0 -> throw IllegalArgumentException(INPUT_ERROR_MSG + MATCHES_ZERO_EXCEPTION_MSG)
            matches.toInt() < 0 -> throw IllegalArgumentException(INPUT_ERROR_MSG + MATCHES_NEGATIVE_NUMBER_EXCEPTION_MSG)
        }
        return true
    }

    companion object {
        private const val DELIMITER: String = ","

        private const val INPUT_ERROR_MSG: String = "잘못된 입력입니다: "

        private const val CARNAME_LESS_THAN_5_EXCEPTION_MSG: String = "자동차 이름에 이름은 5자 이하만 가능합니다."
        private const val CARNAME_WHITESPACE_EXCEPTION_MSG: String = "자동차 이름에 공백을 입력했습니다."
        private const val CARNAME_EMPTY_EXCEPTION_MSG: String = "자동차 이름에 빈 문자을 입력했습니다."
        private const val CARNAME_SAME_CARNAME_EXCEPTION_MSG: String = "자동차 이름에 동일한 이름을 입력했습니다."
        private const val CARNAME_ONE_EXCEPTION_MSG: String = "자동차 게임이 진행가능한 자동차 이름이 하나만 있습니다."

        private const val MATCHES_NOT_INT_EXCEPTION_MSG: String = "시도 횟수에 정수가 아닌 값을 입력했습니다."
        private const val MATCHES_ZERO_EXCEPTION_MSG: String = "시도 횟수에 0을 입력했습니다."
        private const val MATCHES_NEGATIVE_NUMBER_EXCEPTION_MSG: String = "시도 횟수에 음수를 입력했습니다."
    }
}