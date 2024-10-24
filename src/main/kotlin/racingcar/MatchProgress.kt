package racingcar

import camp.nextstep.edu.missionutils.Randoms

class MatchProgress {
    lateinit var registaration: Registaration

    fun racing() {
        val maxRound = registaration.round
        val cars = PreProcessing(registaration).preprocess()

        println("\n실행 결과")
        for (round in 1 .. maxRound) {
            roundInProgress(cars)
        }
        cars.map { it.score = it.roundResult.sum() }
    }

    private fun roundInProgress(cars: List<Result>) {
        cars.map { it.roundResult.add(decideRacingCarMoving()) }
        IOHandler().printRoundResult(cars)
    }

    private fun decideRacingCarMoving(): Int {
        val randomNumber = Randoms.pickNumberInRange(0, 9)

        if (randomNumber < 4) {
            return 0
        }
        return randomNumber - 3
    }

    fun calculateTotalScore(score: List<Int>): Int {
        return score.sum()
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