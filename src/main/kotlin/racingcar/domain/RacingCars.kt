package racingcar.domain

class RacingCars(
    val racingCars: List<RacingCar>,
) {
    fun move(): RacingCars {
        val movingRacingCars = mutableListOf<RacingCar>()

        racingCars.forEach { car ->
            movingRacingCars.add(car.play())
        }

        return RacingCars(movingRacingCars)
    }

    fun getWinners(): List<String> {
        val maxPosition = racingCars.maxOf { it.position }
        return racingCars.filter { it.position == maxPosition }.map { it.name }
    }
}
