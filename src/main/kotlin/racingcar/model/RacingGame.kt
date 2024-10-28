package racingcar.model

class RacingGame(
    private val cars: List<Car>,
) {

    fun playRound() {
        for (car in cars) {
            if (car.canMove()) {
                car.moveForward()
            }
        }
    }

    fun findWinners(): String {
        val maxDistance = cars.maxOf { it.currentDistance }
        return cars
            .filter { it.currentDistance == maxDistance }
            .joinToString(WINNER_SEPARATOR) { it.getName() }
    }

    companion object {
        private const val WINNER_SEPARATOR = ", "
    }
}