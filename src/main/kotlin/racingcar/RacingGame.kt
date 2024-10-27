package racingcar

class RacingGame {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val validator = Validator()
    private lateinit var cars: List<Car>
    private var tryCount: Int = 0

    fun startRace() {
        initializeRace()
        outputView.showRoundResultTitle()
        repeatRounds()
        showWinners()
    }

    private fun initializeRace() {
        val carNames = inputView.getCarNames()
        tryCount = inputView.getTryCount()
        cars = carNames.map { Car(it) }
    }

    private fun repeatRounds() {
        repeat(tryCount) {
            executeRound()
        }
    }

    private fun executeRound() {
        moveAllCars()
        outputView.showRoundFooter()
    }

    private fun moveAllCars() {
        cars.forEach { car ->
            if (validator.isAllowedForMove()) {
                car.move()
            }
            outputView.showCarPosition(car)
        }
    }

    private fun showWinners() {
        val maxPosition = cars.maxOf { it.getCurrentPosition() }
        val winners = cars.filter { it.getCurrentPosition() == maxPosition }.map { it.name }
        outputView.showWinners(winners)
    }
}