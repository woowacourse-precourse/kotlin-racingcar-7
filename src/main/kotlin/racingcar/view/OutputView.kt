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
}
