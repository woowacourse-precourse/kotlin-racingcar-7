package racingcar.view

class OutputView {

    fun printCarMove(carName: String, movedDistance: Int) {
        println("$carName : ${"-".repeat(movedDistance)}")
    }

    fun printWinners(winners: List<String>) {
        println("최종 우승자 : ${winners.joinToString(", ")}")
    }
}