package racingcar.model

class RacingGame {
    private lateinit var cars: List<RacingCar>

    fun getCars(): List<RacingCar> = cars

    fun generateCars(input: List<String>) {
        cars = input.map { RacingCar(it) }
    }

    fun tryRacingGame() = cars.forEach { car -> car.tryMove() }
}