package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(
    private val carList: List<String>,
    private val totalRound: Int,
) {

    // 자동차 경주 게임 스코어를 저장하는 Map
    private val _scoreMap: MutableMap<String, Int> = createScoreMap()
    val scoreMap: Map<String, Int> get() = _scoreMap

    private fun createScoreMap(): MutableMap<String, Int> {
        val scoreMap = carList.associateWith { 0 }.toMutableMap()
        return scoreMap
    }

    fun play() {
        repeat(totalRound) {
            playRound()
        }
    }

    private fun playRound() {
        _scoreMap.forEach { (car, _) ->
            val roundResult = getPlayResult()
            updateScore(
                carName = car,
                result = roundResult
            )
        }
    }

    private fun updateScore(carName: String, result: PlayResult) {
        if(result == PlayResult.GO) {
            _scoreMap[carName] = _scoreMap[carName]!! + 1
        }
    }

    private fun getPlayResult(): PlayResult {
        val playNum = createPlayNum()
        val playResult = if(playNum < PLAY_CRITICAL_POINT) PlayResult.STOP else PlayResult.GO
        return playResult
    }

    private fun createPlayNum(): Int {
        val playNum = Randoms.pickNumberInRange(
            /* startInclusive = */ PLAY_NUMBER_START,
            /* endInclusive = */ PLAY_NUMBER_END,
        )
        return playNum
    }

    fun getWinners(): Set<String> {
        val maxScore = scoreMap.values.maxOrNull()
        val winners = scoreMap.filter { it.value == maxScore }.keys
        return winners
    }

    companion object {
        private const val PLAY_CRITICAL_POINT = 4
        private const val PLAY_NUMBER_START = 0
        private const val PLAY_NUMBER_END = 9
    }

}