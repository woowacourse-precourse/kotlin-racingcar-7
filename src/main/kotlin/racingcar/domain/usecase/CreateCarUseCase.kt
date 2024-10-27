package racingcar.domain.usecase

import racingcar.domain.entity.Car

class CreateCarUseCase {
    private var anonymityCount = INITIAL_ANONYMITY_COUNT

    fun execute(input: String): List<Car> {
        val carNames = input.split(DELIMITER)
        validateCarNames(carNames)
        return carNames.map { name -> createCarWithName(name) }
    }

    private fun createCarWithName(name: String): Car {
        val processedName = if (name.trim().isEmpty()) "$ANONYMITY${anonymityCount++}" else name
        return Car(processedName)
    }

    private fun validateCarNames(carNames: List<String>) = carNames.forEach { name ->
        validateCarNamesLength(name)
    }

    private fun validateCarNamesLength(name: String) =
        require(name.length > NAME_COUNT_LIMIT) { println(OVER_NAME_COUNT_MESSAGE) }

    companion object {
        private const val ANONYMITY = "익명"
        private const val OVER_NAME_COUNT_MESSAGE = "자동차 이름을 5글자 이하로 작성해주세요!"
        private const val NAME_COUNT_LIMIT = 5
        private const val DELIMITER = ","
        private const val INITIAL_ANONYMITY_COUNT = 1
    }
}
