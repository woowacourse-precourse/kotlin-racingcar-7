package racingcar

import camp.nextstep.edu.missionutils.Console

class Game {
    companion object {
        const val INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val INPUT_ATTEMPT_TIMES_MESSAGE = "시도할 횟수는 몇 회인가요?"
        const val WINNERS_ANNOUNCEMENT_MESSAGE = "최종 우승자 : "
    }

    fun inputData() {
        inputCarNames()
        inputAttemptTimes()
        GameManager.getRound()
    }

    private fun inputCarNames() {
        println(INPUT_CAR_NAMES_MESSAGE)
        GameManager.generateCars(Console.readLine())
    }

    private fun inputAttemptTimes() {
        println(INPUT_ATTEMPT_TIMES_MESSAGE)
        GameManager.setAttemptTimes(Console.readLine())
    }

    fun play() {
        GameManager.playRound()
    }

    fun printWinners() {
        val winners = GameManager.getWinners().joinToString(separator = ", ")
        println("$WINNERS_ANNOUNCEMENT_MESSAGE$winners")
    }
}