package racingcar.control

class WinnerSelector {
    fun selectWinner(raceOver: List<CarData>): String {
        val winnerPoint = raceOver.maxByOrNull { it.point }?.point
        return raceOver.filter { it.point == winnerPoint }.joinToString { it.name }
    }
}