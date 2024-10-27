package racingcar

class Presenter(private val view: View) {
    private val model: Model = Model(Validator())

    fun execute(name: String, iterationCount: String) {
        val validated = model.validation(name, iterationCount)
        val roundResults = deliverRoundResults(validated)
        deliverFullResults(roundResults)
    }

    private fun deliverRoundResults(validated: Pair<MutableMap<String, Int>, Int>): MutableList<MutableMap<String, Int>> {
        val roundResults = model.forward(validated)
        view.printResult(roundResults)
        return roundResults
    }

    private fun deliverFullResults(roundResults: MutableList<MutableMap<String, Int>>) {
        val winner = model.findWinner(roundResults.last())
        view.printWinners(winner)
    }
}