package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(
    private val carList: String,
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

    private fun printResult() {
        println(GAME_RESULT_TILE)
        printGameScore()
        println()
        printGameWinners()
    }

    private fun printGameScore() {
        playCars.forEach { (car, score) ->
            println("$car : ${score.toScoreSymbol()}")
        }
    }

    private fun Int.toScoreSymbol(): String {
        val scoreSymbol = "-"
        return scoreSymbol.repeat(this)
    }

    private fun printGameWinners() {
        print(GAME_RESULT_WINNER_TILE)
        print(getWinners().joinToString(", "))
    }

    companion object {
        private const val GAME_CRITICAL_POINT = 4
        private const val PLAY_NUMBER_START = 0
        private const val PLAY_NUMBER_END = 9
        private const val GAME_RESULT_TILE = "-----자동차 경주 결과-----"
        private const val GAME_RESULT_WINNER_TILE = "♣ 최종 우승자 : "
    }

}