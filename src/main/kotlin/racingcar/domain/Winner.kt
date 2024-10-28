package racingcar.domain

class Winner(
    private val cars: List<Car>
) {

    fun getWinner(): String {
        val maxDistance = findMaxDistance()
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

    private fun findMaxDistance() =
        cars.maxOfOrNull { it.distance.length } ?: throw IllegalArgumentException(EMPTY_MAX_DISTANCE_ERROR_MESSAGE)

    companion object {
        private const val SEPARATOR = ", "
        private const val EMPTY_MAX_DISTANCE_ERROR_MESSAGE = "최대거리가 비어있으면 우승자를 구할 수 없습니다."
    }

}
