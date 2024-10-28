package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame {

    fun getPlayResult(): PlayResult {
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

    companion object {
        private const val GAME_CRITICAL_POINT = 4
        private const val PLAY_NUMBER_START = 0
        private const val PLAY_NUMBER_END = 9
    }

}