package racingcar.domain.factory

import racingcar.domain.entity.Car

class CarFactory {
    private var anonymityCount = INITIAL_ANONYMITY_COUNT

    fun buildCars(input: String): List<Car> {
        val carsName = input.split(DELIMITER)
        validateCarsName(carsName)
        return carsName.map { name -> buildCar(name) }
    }

    private fun buildCar(name: String): Car {
        if (name.trim().isEmpty()) return Car(ANONYMITY + anonymityCount++)
        return Car(name)
    }

    private fun validateCarsName(carsName: List<String>) = carsName.forEach { name ->
        require(name.length <= NAME_COUNT_LIMIT) { println(OVER_NAME_COUNT_MESSAGE) }
    }

    companion object {
        private const val ANONYMITY = "익명"
        private const val OVER_NAME_COUNT_MESSAGE = "자동차 이름을 5글자 이하로 작성해주세요!"
        private const val NAME_COUNT_LIMIT = 5
        private const val DELIMITER = ","
        private const val INITIAL_ANONYMITY_COUNT = 1
    }
}