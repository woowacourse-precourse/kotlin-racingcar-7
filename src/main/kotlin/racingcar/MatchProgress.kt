package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Racing {
    lateinit var registaration: Registaration

    fun racing(): List<Result> {
        val maxRound = registaration.round
        val cars = PreProcessing(registaration).preprocess()

        println("\n실행 결과")
        for (round in 1 .. maxRound) {
            roundInProgress(cars)
        }
        cars.map { it.score = calculateTotalScore(it.roundResult) }
        return cars
    }

    private fun roundInProgress(cars: List<Result>) {
        cars.map { it.roundResult.add(decideRacingCarMoving()) }
        OutputHandler().printRoundResult(cars)
    }

    private fun decideRacingCarMoving(): Int {
        val randomNumber = Randoms.pickNumberInRange(0, 9)

        if (randomNumber < 4) {
            return 0
        }
        return randomNumber - 3
    }

    private fun calculateTotalScore(score: List<Int>): Int {
        return score.sum()
    }
}

class Rewarding(private val cars: List<Result>) {
    fun awardWinner() {
        val winner = findWinner()

        OutputHandler().printWinner(winner)
    }

    private fun findWinner(): List<Result> {
        val winnerScore = cars.map { it.score }

        return cars.filter { it.score == winnerScore.max() }
    }
}

class PreProcessing(private var registaration: Registaration) {
    fun preprocess(): List<Result> {
        val validation = Validation()
        val cars = mutableListOf<Result>()

        validation.isDelimitersCorrect(registaration)
        splitCars().map {
            if (validation.isCarNameUnder5(it)) {
                cars.add(Result(carName = it))
            }
        }
        return cars
    }

    private fun splitCars(): List<String> {
        return registaration.cars.split(",")
    }

}

data class Result(
    val carName: String,
    var roundResult: MutableList<Int> = mutableListOf(),
    var score: Int = 0,
)