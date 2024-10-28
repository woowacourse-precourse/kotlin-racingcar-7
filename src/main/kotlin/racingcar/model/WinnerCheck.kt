package racingcar.model

object WinnerCheck {
    fun pickWinner(currentStatus: MutableList<Pair<String, Int>>): MutableList<String> {
        val winners = mutableListOf<String>()
        val maxPosition = currentStatus.maxOf { it.second }
        currentStatus.forEach { (name, position) ->
            if (maxPosition == position) winners.add(name)
        }
        return winners
    }
}