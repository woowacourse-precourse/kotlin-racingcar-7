package racingcar.view

class OutputView {

    fun printRacingStart() {
        println("\n실행 결과")
    }

    fun printRacingProgress(racing: List<Pair<String, Int>>) {
        racing.forEach {
            println("${it.first} : ${"-".repeat(it.second)}")
        }
        println()
    }

    fun printWinners(winners: List<String>) {
        print("최종 우승자 : ${winners.joinToString(", ")}")
    }
}