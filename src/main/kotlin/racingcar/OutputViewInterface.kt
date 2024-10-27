package racingcar

interface OutputViewInterface {
    fun printRaceResult(cars: List<Car>)

    fun printRaceWinners(winners: List<Car>)
}