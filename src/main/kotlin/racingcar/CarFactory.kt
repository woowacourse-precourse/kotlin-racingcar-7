package racingcar

class CarFactory {

    fun buildCars(input: String): List<Car> {
        val carsName = input.split(DELIMITER)
        validateCarsName(carsName)
        return carsName.map { name -> Car(name) }
    }

    private fun validateCarsName(carsName: List<String>) = carsName.forEach { name ->
        require(name.length <= NAME_COUNT_LIMIT) { println(OVER_NAME_COUNT_MESSAGE) }
    }

    companion object {
        private const val DELIMITER = ","
        private const val NAME_COUNT_LIMIT = 5
        private const val OVER_NAME_COUNT_MESSAGE = "자동차 이름을 5글자 이하로 작성해주세요!"
    }
}