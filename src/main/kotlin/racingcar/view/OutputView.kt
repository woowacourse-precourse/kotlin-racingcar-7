package racingcar.view

object OutputView {
    fun currentStatusPrint(currentStatus: MutableList<Pair<String, Int>>) {
        currentStatus.forEach { (name, position) ->
            print("$name : ")
            repeat(position) {
                print('-')
            }
            println()
        }
    }

    fun winnerPrint(winners: MutableList<String>) {
        val result = winners.joinToString(",")
        println("최종 우승자 : $result")
    }
}
