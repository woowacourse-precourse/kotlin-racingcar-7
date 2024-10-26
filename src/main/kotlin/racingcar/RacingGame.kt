package racingcar

class RacingGame {
    private val computer = Computer()
    private val validation = Validation()

    fun gameStart() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        var cars = initCar()
    }

    private fun initCar(): List<Car> {
        val inputCarNames = computer.inputCarName()
        val carName = splitCarName(inputCarNames)
        validation.validateCarName(carName)
        return carName
    }

    private fun splitCarName(carName: String): List<Car> {
        return carName.split(",").map { Car(it) }
    }
}