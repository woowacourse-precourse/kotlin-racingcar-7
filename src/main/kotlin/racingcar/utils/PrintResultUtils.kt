package racingcar.utils


object ResultPrintUtils {

    private const val GAME_RESULT_TILE = "-----자동차 경주 결과-----"

    /**
     * 자동차 경주 게임 결과(게임 스코어와 승자)를 출력한다.
     * @param scoreMap 자동차 게임 스코어가 저장되어 있는 Map
     * @param winners 자동차 게임 우승자가 들어있는 Set
     */
    fun printResult(scoreMap: Map<String, Int>, winners: Set<String>) {
        println(GAME_RESULT_TILE)
        printGameScore(scoreMap)
        println()
        printGameWinners(winners)
    }

    private fun printGameScore(scoreMap: Map<String, Int>) {
        scoreMap.forEach { (car, score) ->
            println("$car : ${score.toScoreSymbol()}")
        }
    }

    private const val GAME_SCORE_SYMBOL = "-"
    private fun Int.toScoreSymbol(): String {
        return GAME_SCORE_SYMBOL.repeat(this)
    }

    private const val GAME_RESULT_WINNER_TILE = "♣ 최종 우승자 : "
    private fun printGameWinners(winners: Set<String>) {
        print(GAME_RESULT_WINNER_TILE)
        print(winners.joinToString(", "))
    }

}