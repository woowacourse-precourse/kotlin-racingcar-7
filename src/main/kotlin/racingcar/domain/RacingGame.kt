package racingcar.domain

class RacingGame(private val carNames: List<String>) {
    private val racingCars: MutableList<RacingCar> = mutableListOf()

    init {
        setRacingCars()
    }

    private fun setRacingCars() {
        carNames.forEach { racingCars.add(RacingCar(it)) }
    }
}