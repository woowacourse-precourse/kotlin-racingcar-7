package racingcar.domain.usecase

import racingcar.domain.entity.Car

class CreateCarUseCase {
    private var anonymityCount = INITIAL_ANONYMITY_COUNT

    fun execute(input: String): List<Car> {
        val carNames = input.split(DELIMITER)
        validateCarNames(carNames)
        return carNames.map { name -> createCar(name) }
    }

    private fun createCar(name: String): Car {
        if (name.trim().isEmpty()) return Car("$ANONYMITY${anonymityCount++}")
        return Car(name)
    }

    private fun validateCarNames(carNames: List<String>) {
        validateUniqueName(carNames)
        carNames.forEach { name ->
            validateCarNamesLength(name)
        }
    }

    private fun validateUniqueName(carNames: List<String>) {
        val isDuplicate = carNames.distinct().size == carNames.size
        require(isDuplicate) { println(DUPLICATE_CARS_ERROR_MESSAGE) }
    }

    private fun validateCarNamesLength(name: String) =
        require(name.length <= NAME_COUNT_LIMIT) { println(OVER_NAME_COUNT_MESSAGE) }

    companion object {
        private const val INITIAL_ANONYMITY_COUNT = 1
        private const val DELIMITER = ","
        private const val ANONYMITY = "익명"
        private const val DUPLICATE_CARS_ERROR_MESSAGE = "자동차 이름에 중복이 있습니다. 중복을 제거 해주세요"
        private const val OVER_NAME_COUNT_MESSAGE = "자동차 이름을 5글자 이하로 작성해주세요!"
        private const val NAME_COUNT_LIMIT = 5

    }
}
