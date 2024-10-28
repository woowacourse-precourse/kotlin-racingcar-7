package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(
    private val carList: List<String>,
    private val totalRound: Int,
) {

    private val playCars: MutableMap<String, Int> = getCarMap()

    private fun getCarMap(): MutableMap<String, Int> {
        val carList = carList.split(",")
        val carMap = carList.associateWith { 0 }.toMutableMap()
        return carMap
    }

    fun play() {
        repeat(totalRound) {
            playRound()
        }
        printResult()
    }

    private fun playRound() {
        playCars.forEach { (car, _) ->
            val roundResult = getPlayResult()
            updateGameScore(
                carName = car,
                result = roundResult
            )
        }
    }

    private fun updateGameScore(carName: String, result: PlayResult) {
        if(result == PlayResult.GO) {
            playCars[carName] = playCars[carName]!! + 1
        }
    }

    private fun getPlayResult(): PlayResult {
        val playNum = getPlayNum()
        val playResult = if(playNum < GAME_CRITICAL_POINT) PlayResult.STOP else PlayResult.GO
        return playResult
    }

    private fun getPlayNum(): Int {
        val playNum = Randoms.pickNumberInRange(
            /* startInclusive = */ PLAY_NUMBER_START,
            /* endInclusive = */ PLAY_NUMBER_END
        )
        return playNum
    }

    private fun getWinners(): Set<String> {
        val maxScore = playCars.values.max()
        val winners = playCars.filter { it.value == maxScore }.keys
        return winners
    }

    companion object {
        private const val PLAY_CRITICAL_POINT = 4
        private const val PLAY_NUMBER_START = 0
        private const val PLAY_NUMBER_END = 9
    }

}