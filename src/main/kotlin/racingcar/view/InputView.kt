package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun getCarNames(): String {
        println(NAME_QUEST_MSG)
        return read()
    }

    fun getRounds(): String {
        println(ROUND_QUEST_MSG)
        val rounds = read()
        return rounds
    }

    private fun read(): String = Console.readLine() ?: throw IllegalArgumentException()

    fun close() = Console.close()

    companion object {
        private const val NAME_QUEST_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val ROUND_QUEST_MSG = "시도할 횟수는 몇 회인가요?"
    }
}