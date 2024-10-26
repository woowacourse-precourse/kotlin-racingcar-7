package racingcar.view

import camp.nextstep.edu.missionutils.Console.readLine

class CommandLineView(private val viewModel: ViewModel = ViewModel()) : View {
    override fun requestCarNames() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carNames: String = readLine().takeIf { it.isNotBlank() } ?: throw IllegalArgumentException()
        viewModel.updateCarNames(carNames)
    }

    override fun requestRoundCount() {
        println("시도할 횟수는 몇 회인가요?")
        val round: Int = readLine().toIntOrNull() ?: throw IllegalArgumentException()
        viewModel.updateRound(round)
    }

    override fun showMatchProcess() {
        TODO("Not yet implemented")
    }

    override fun showWinner() {
        TODO("Not yet implemented")
    }
}