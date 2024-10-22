package racingcar

class CarFactory {

    fun buildCars(input: String): List<Car> {
        val carsName = input.split(",")
        validateCarsName(carsName)
        return carsName.map { name -> Car(name) }
    }

    private fun validateCarsName(carsName: List<String>) = carsName.forEach { name ->
        require(name.length <= 5) { println("자동차 이름을 5글자 이하로 작성해주세요!") }
    }
}