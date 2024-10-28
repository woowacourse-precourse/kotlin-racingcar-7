package racingcar.view

class OutputView {
    fun showPrompt(message: String) {
        println(message)
    }

    fun displayRacingProgress(name: String, scoreSymbol: String) {
        println("$name : $scoreSymbol")
    }

    fun displayWinner(winner: String) {
        println("최종 우승자 : $winner")
    }
}