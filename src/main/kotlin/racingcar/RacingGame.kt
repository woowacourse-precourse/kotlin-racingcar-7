package racingcar

class RacingGame {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val validator = Validator()
    private lateinit var cars: List<Car>

    fun startRace() {
        val carNames = inputView.getCarNames()
        val tryCount = inputView.getTryCount()

        cars = carNames.map { Car(it) }

        outputView.showRoundResultTitle()
        repeat(tryCount) {
            executeRound()
        }
        showWinners()
    }

    private fun executeRound() {
        moveAllCars()
        outputView.showRoundFooter()
    }

    private fun moveAllCars() {
        cars.forEach { car ->
            moveCarIfAllowed(car)
            outputView.showCarPosition(car)
        }
    }

    private fun moveCarIfAllowed(car: Car) {
        if (validator.isAllowedForMove()) {
            car.move()
        }
    }

    private fun showWinners() {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }.map { it.name }
        outputView.showWinners(winners)
    }
}