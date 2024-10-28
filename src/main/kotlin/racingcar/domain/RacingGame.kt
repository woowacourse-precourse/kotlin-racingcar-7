package racingcar.domain

class RacingGame(
    private val carNames: List<String>,
    private val gameRound: Int
) {
    private var racingCars: List<RacingCar>? = null

    init {
        setRacingCars()
    }

    private fun setRacingCars() {
        racingCars = carNames.map { RacingCar(it) }
    }

    fun play() {
        for (i in 1..gameRound) {
            playRound()
        }
    }

    private fun playRound() {
        racingCars?.forEach { it.play() }
    }
}