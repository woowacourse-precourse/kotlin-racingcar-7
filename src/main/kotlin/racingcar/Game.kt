package racingcar

class Game {
    val reader = Reader()
    val monitor = Monitor()

    fun startGame() {
        val carList = getCarList()
        val tryGame = getTryCount()
        val maxDistance = startRace(carList, tryGame)
        displayWinners(carList, maxDistance)
    }

    private fun createCars(): List<Car> {
        val carList = Driver().getValidDriver()
        return carList.map { Car(it) }
    }

    private fun getCarList(): List<Car> {
        monitor.displayInputCar()
        return createCars()
    }

    private fun startRace(carList: List<Car>, tryCount: Int): Int {
        return CarFactory().displayCarRace(carList, tryCount)
    }

    private fun displayWinners(carList: List<Car>, maxDistance: Int) {
        val winners = findWinner(carList, maxDistance)
        monitor.displayWinner(winners)
    }

    private fun findWinner(cars: List<Car>, maxDistance: Int): String {
        return cars.filter { it.distance == maxDistance }.joinToString(",") { it.name }
    }

    private fun validCarCount(): Int {
        return reader.inputNum().toIntOrNull() ?: throw IllegalArgumentException(ERROR_INPUT_INT)
    }

    private fun getTryCount(): Int {
        monitor.displayTryCount()
        return validCarCount()
    }

    companion object {
        const val ERROR_INPUT_INT = "숫자를 입력해주세요"
    }
}