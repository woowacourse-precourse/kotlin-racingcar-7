package racingcar.domain.usecase

import racingcar.domain.entity.Car

class CreateCarsUseCase {
    private var anonymityCount = INITIAL_ANONYMITY_COUNT

    fun execute(input: String): List<Car> {
        val carNames = input.split(DELIMITER)
        validateUniqueName(carNames)
        return carNames.map { name -> createCar(name) }
    }

    private fun createCar(name: String): Car {
        if (name.isBlank()) return Car("$ANONYMITY${anonymityCount++}")
        return Car(name)
    }

    private fun validateUniqueName(carNames: List<String>) {
        val isDuplicate = carNames.distinct().size == carNames.size
        require(isDuplicate) { println(DUPLICATE_CARS_ERROR_MESSAGE) }
    }

    companion object {
        private const val INITIAL_ANONYMITY_COUNT = 1
        private const val DELIMITER = ","
        private const val ANONYMITY = "익명"
        private const val DUPLICATE_CARS_ERROR_MESSAGE = "자동차 이름에 중복이 있습니다. 중복을 제거 해주세요"
    }
}
