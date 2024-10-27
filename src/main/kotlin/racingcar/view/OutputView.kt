package racingcar.view

import racingcar.model.RacingCar

class OutputView {
    fun printDefaultMessage() {
        println(OutputMessage.DEFAULT_MESSAGE.message)
    }

    fun printResult(carList: List<RacingCar>) {
        carList.map { println(it) } // 각 자동차의 상태 출력
        println() // 각 시도 결과 사이에 빈 줄 추가
    }

    fun printWinners(winners: List<RacingCar>) {
        println(OutputMessage.WINNERS.message + winners.joinToString(", "))
    }

    enum class OutputMessage(
        val message: String,
    ) {
        DEFAULT_MESSAGE("실행 결과"),
        WINNERS("최종 우승자 : "),
    }
}
