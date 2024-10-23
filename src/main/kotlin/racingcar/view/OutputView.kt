package racingcar.view

class OutputView {
    // println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    // println("시도할 횟수는 몇 회인가요?")
    // println("실행 결과")

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