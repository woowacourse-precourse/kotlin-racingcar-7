package racingcar

class RacingGame(
    private val cars: List<Car>,
    private val tryCount: Int,
) {
    private val validator = Validator()
    private val outputView = OutputView()

    fun startRace() {
        outputView.showRoundResultTitle()
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
            moveCarIfAllowed(car)
            outputView.showCarPosition(car)
        }
    }

    private fun moveCarIfAllowed(car: Car) {
        if (validator.isAllowedForMove()) {
            car.move()
        }
    }
}