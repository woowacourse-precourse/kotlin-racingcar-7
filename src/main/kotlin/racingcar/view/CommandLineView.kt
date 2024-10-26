package racingcar.view

import camp.nextstep.edu.missionutils.Console.readLine

class CommandLineView : View {
    override fun requestCarNames(): String {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        return readLine().takeIf { it.isNotBlank() } ?: throw IllegalArgumentException()
    }

    override fun requestRoundCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine().toIntOrNull() ?: throw IllegalArgumentException()
    }

    override fun showMatchProcess() {
        TODO("Not yet implemented")
    }

    override fun showWinner() {
        TODO("Not yet implemented")
    }
}