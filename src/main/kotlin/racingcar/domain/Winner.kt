package racingcar.domain

class Winner(
    private val cars: List<Car>
) {

    fun getWinner(): String {
        val maxDistance = getMaxDistance()
        val winnerList = findWinner(maxDistance)
        val winner = winnerList.joinToString(SEPARATOR) { car ->
            car.carName
        }
        return winner
    }

    private fun findWinner(maxDistance: Int): List<Car> =
        cars.filter { car ->
            car.distance.length == maxDistance
        }

    private fun getMaxDistance() = cars.maxOf { it.distance.length }

    companion object {
        private const val SEPARATOR = ", "
    }

}
