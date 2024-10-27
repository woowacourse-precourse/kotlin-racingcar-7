package racingcar.control

class WinnerSelection {

    fun winnerSelection(raceOver: List<CarData>): String {
        val winnerPoint = raceOver.maxByOrNull { it.point }?.point
        return raceOver.filter { it.point == winnerPoint }.map { it.name }.joinToString()
    }
}