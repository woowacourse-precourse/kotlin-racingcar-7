package racingcar

class RacingGame {
    private val computer = Computer()
    private val validation = Validation()

    fun gameStart() {
        val cars = initCar()
        val roundCounts = initRound()
        playGame(cars, roundCounts)
        val winner = determinedWinners(cars)
        computer.printWinner(winner)
    }

    fun determinedWinners(cars: List<Car>): List<Car> {
        val winnerPosition = cars.maxOf { it.position }
        return cars.filter { it.position == winnerPosition }
    }

    private fun initCar(): List<Car> {
        val inputCarNames = computer.inputCarName()
        val carName = splitCarName(inputCarNames)
        validation.validateCarName(carName)
        return carName
    }

    private fun initRound(): Int {
        val inputRoundCount = computer.inputRoundCount()
        validation.validateRoundCount(inputRoundCount)
        return inputRoundCount.toInt()
    }

    private fun playGame(cars: List<Car>, roundCount: Int) {
        printGameResultMessage()
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

    private fun printGameResultMessage() {
        println("\n실행 결과")
    }

    private fun splitCarName(carName: String): List<Car> {
        return carName.split(",").map { Car(it) }
    }
}