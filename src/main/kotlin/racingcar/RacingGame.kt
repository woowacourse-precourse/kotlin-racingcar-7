package racingcar

class RacingGame {
    private val computer = Computer()
    private val validation = Validation()

    fun gameStart() {
        val cars = initCar()
        val roundCounts = initRound()
        playGame(cars, roundCounts)
    }

    private fun initCar(): List<Car> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val inputCarNames = computer.inputCarName()
        val carName = splitCarName(inputCarNames)
        validation.validateCarName(carName)
        return carName
    }

    private fun initRound(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val inputRoundCount = computer.inputRoundCount()
        validation.validateRoundCount(inputRoundCount)
        return inputRoundCount.toInt()
    }

    private fun playGame(cars: List<Car>, roundCount: Int) {
        println("\n실행 결과")
        repeat(roundCount) {
            moveCars(cars)
            println()
        }
    }

    private fun moveCars(cars: List<Car>) {
        cars.forEach { car ->
            car.moving(computer.generate())
            computer.printCarPosition(car)
        }
    }

    private fun splitCarName(carName: String): List<Car> {
        return carName.split(",").map { Car(it) }
    }
}